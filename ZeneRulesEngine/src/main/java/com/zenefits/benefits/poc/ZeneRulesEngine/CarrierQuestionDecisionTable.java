package com.zenefits.benefits.poc.ZeneRulesEngine;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleFact;

@Component
public class CarrierQuestionDecisionTable implements ApplicationListener<ContextRefreshedEvent> {
	public static StatelessKnowledgeSession KSESSION;

	private static KnowledgeBase createKnowledgeBaseFromSpreadsheet() throws Exception {
		DecisionTableConfiguration dtconf = KnowledgeBuilderFactory.newDecisionTableConfiguration();
		dtconf.setInputType(DecisionTableInputType.XLS);

		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory.newClassPathResource("rules/carrier_questions.xls"), ResourceType.DTABLE, dtconf);		

		if (knowledgeBuilder.hasErrors()) {
			throw new RuntimeException(knowledgeBuilder.getErrors().toString());
		}		

		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());
		return knowledgeBase;
	}

	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		KnowledgeBase knowledgeBase;
		try {
			System.out.println("===== Loading Rules ==== ");
			knowledgeBase = createKnowledgeBaseFromSpreadsheet();
			KSESSION = knowledgeBase.newStatelessKnowledgeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
