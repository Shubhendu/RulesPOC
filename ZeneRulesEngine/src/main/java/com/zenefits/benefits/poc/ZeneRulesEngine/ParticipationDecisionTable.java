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
public class ParticipationDecisionTable implements ApplicationListener<ContextRefreshedEvent> {
	public static StatelessKnowledgeSession KSESSION;
	
//	public static void main(String[] args) throws Exception {
//		KnowledgeBase knowledgeBase = createKnowledgeBaseFromSpreadsheet();
//		KSESSION = knowledgeBase.newStatelessKnowledgeSession();
//		ParticipationRuleFact participationRuleFact = new ParticipationRuleFact("Anthem", "CA", "medical", "voluntary", "", 23, 12);
//		KSESSION.execute(participationRuleFact);
//
//		System.out.println("Participation Rule- No. of EEs: " + participationRuleFact.getMinimumNumberOfEEs()+" Percent: "+participationRuleFact.getMinimumPercentageOfEEs());
//		ParticipationRuleFact participationRuleFactTwo = new ParticipationRuleFact("Anthem", "NV", "medical", "voluntary", "", 65, 9);
//		KSESSION.execute(participationRuleFactTwo);
//
//		System.out.println("Participation Rule- No. of EEs: " + participationRuleFactTwo.getMinimumNumberOfEEs()+" Percent: "+participationRuleFactTwo.getMinimumPercentageOfEEs());
//	}

	private static KnowledgeBase createKnowledgeBaseFromSpreadsheet() throws Exception {
		DecisionTableConfiguration dtconf = KnowledgeBuilderFactory.newDecisionTableConfiguration();
		dtconf.setInputType(DecisionTableInputType.XLS);

		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory.newClassPathResource("rules/participation_exception_rules.xls"), ResourceType.DTABLE, dtconf);
		knowledgeBuilder.add(ResourceFactory.newClassPathResource("rules/participation_rules.xls"), ResourceType.DTABLE, dtconf);
		

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
