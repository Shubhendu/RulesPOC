package com.zenefits.benefits.poc.ZeneRulesEngine;


import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

/**
 * Hello world!
 *
 */
public class App 
{
//	public static void main( String[] args )
//
//	{ 
////
////		/**
////		 * Method 1 - Old way
////		 */
////		CarrierMetadata carrierMetadata = new CarrierMetadata();
////		carrierMetadata.setName("Aetna");
////		carrierMetadata.setState("NV");
////		ParticipationRuleResponse participationRuleResponse = new ParticipationRuleResponse();
////
////		//		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
////		//		kbuilder.add(ResourceFactory.newClassPathResource("participationRule.drl"), ResourceType.DRL);
////		//		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
////		//		KnowledgeBase kbase;
////		//		try {
////		//			kbase = createKnowledgeBaseFromSpreadsheet();
////		//			StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
////		//			ksession.execute(carrierMetadata);
////		//			System.out.println("Percent: "+carrierMetadata.getGroupSize()+" EEs: " +carrierMetadata.getMinEEs());
////		//		} catch (Exception e) {
////		//			// TODO Auto-generated catch block
////		//			e.printStackTrace();
////		//		}
////
////
////		/**
////		 * Method 2
////		 */
////
////
////
////		// Create drl file from excel sheet
////		InputStream is =null;
////		try {
////			is= new FileInputStream("/Users/ssingh/Documents/workspace/poc/ZeneRulesEngine/src/main/resources/rules/participation_rules.xls");
////		} catch (FileNotFoundException e) {
////			e.printStackTrace();
////		}
////		// Create compiler class instance
////		SpreadsheetCompiler sc = new SpreadsheetCompiler();
////
////		// Compile the excel to generate the (.drl) file
////		StringBuffer drl=new StringBuffer(sc.compile(is, InputType.XLS));
////
////		// Insert dialect value into drl file
////		drl.insert(drl.indexOf("DROOLS")+40,"dialect \"mvel\""+"\n");
////
////		// Check the generated drl file
////		System.out.println("Generate DRL file is showing below–: ");
////		System.out.println(drl);
////
////		KieServices kieServices = KieServices.Factory.get();
////		KieContainer kieContainer = kieServices.getKieClasspathContainer();
////		KieSession kieSession = kieContainer.newKieSession("ksession-rules");
////		kieSession.insert(carrierMetadata);
////		kieSession.insert(participationRuleResponse);
////		kieSession.fireAllRules();
////		System.out.println("Percent: "+participationRuleResponse.getMinimumPercentageOfEEs());
////		System.out.println("Participation rule: "+participationRuleResponse.getMinimumNumberOfEEs());
////		kieSession.dispose();
//		
//		//		KieContainer kContainer = ks.getKieClasspathContainer();
//		//		KieSession kSession = kContainer.newKieSession("ksession-rules");
//		
////		//		kSession.setGlobal("participationRuleResponse", participationRuleResponse);
//
//		//        QueryResults results = workingMemory.getQueryResults( "eligInqs" );
//
//
//	}

	private static KnowledgeBase createKnowledgeBaseFromSpreadsheet() throws Exception {

		DecisionTableConfiguration dtconf = KnowledgeBuilderFactory.newDecisionTableConfiguration();

		dtconf.setInputType(DecisionTableInputType.XLS);

		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		knowledgeBuilder.add(ResourceFactory.newClassPathResource("participation_rules.xls"), ResourceType.DTABLE, dtconf);

		if (knowledgeBuilder.hasErrors()) {

			throw new RuntimeException(knowledgeBuilder.getErrors().toString());

		}

		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();

		knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());
		return knowledgeBase;

	}
}
