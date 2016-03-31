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

import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleFact;

public class ParticipationDecisionTable {
	private static StatelessKnowledgeSession session;

	public static void main(String[] args) throws Exception {
		KnowledgeBase knowledgeBase = createKnowledgeBaseFromSpreadsheet();
		session = knowledgeBase.newStatelessKnowledgeSession();
		ParticipationRuleFact participationRuleFact = new ParticipationRuleFact("Anthem",
																	"CA",
																	"medical",
																	"voluntary",
																	"",
																	23,
																	12);
		session.execute(participationRuleFact);

		System.out.println("Participation Rule Satisfied? \n" + participationRuleFact.isParticipationRuleSatisfied());
		ParticipationRuleFact participationRuleFactTwo = new ParticipationRuleFact("Anthem",
				"CA",
				"medical",
				"voluntary",
				"",
				23,
				9);
		session.execute(participationRuleFactTwo);

		System.out.println("Participation Rule Satisfied? \n" + participationRuleFactTwo.isParticipationRuleSatisfied());
	}

	private static KnowledgeBase createKnowledgeBaseFromSpreadsheet()
			throws Exception {
		DecisionTableConfiguration dtconf = KnowledgeBuilderFactory
				.newDecisionTableConfiguration();
		dtconf.setInputType(DecisionTableInputType.XLS);

		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory.newClassPathResource("rules/participation_rules.xls"), ResourceType.DTABLE, dtconf);

		if (knowledgeBuilder.hasErrors()) {
			throw new RuntimeException(knowledgeBuilder.getErrors().toString());
		}		

		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());
		return knowledgeBase;
	}
}
