package com.zenefits.benefits.poc.ZeneRulesEngine.services;


import java.util.Arrays;
import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.zenefits.benefits.poc.ZeneRulesEngine.RulesLoader;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.CarrierQuestionFact;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.CarrierQuestionsRuleResponse;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleFact;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleResponse;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.Response.STATUS;
import com.zenefits.benefits.poc.ZeneRulesEngine.util.TrackingAgendaEventListener;

@Service
public class IRuleServiceImpl implements IRulesService{
	
	public ParticipationRuleResponse executeParticipationRule(ParticipationRuleFact participationRuleFact) {
		ParticipationRuleResponse participationRuleResponse = new ParticipationRuleResponse();
		participationRuleResponse.startExecution();
		KieSession kSession = RulesLoader.PARTICIPATION_RULE_SESSION;
		TrackingAgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
		kSession.addEventListener(agendaEventListener);
		kSession.insert(participationRuleFact);
		kSession.fireAllRules(1);

		Integer minNumberOfEEs = participationRuleFact.getMinimumNumberOfEEs();
		Double minPercentOfEEs = participationRuleFact.getMinimumPercentageOfEEs();
		boolean rulesAvailable = false;
		boolean rulesPassed = false;
		boolean minNumberOfEEsRulesPassed = false;
		boolean minPercentOfEEsRulesPassed = false;

		String operand = participationRuleFact.getOperand();

		double percentOfEesEnrolled = participationRuleFact.getNumberOfEnrolled().doubleValue()/participationRuleFact.getGroupSize().doubleValue();

		if (minNumberOfEEs != null) {
			rulesAvailable = true;
			if(participationRuleFact.getNumberOfEnrolled() >= minNumberOfEEs){
				minNumberOfEEsRulesPassed = true;
			}
		}

		if (minPercentOfEEs != null) {
			rulesAvailable = true;
			if ( percentOfEesEnrolled >= minPercentOfEEs) {
				minPercentOfEEsRulesPassed = true;
			}
		}
		
		if(rulesAvailable){
			participationRuleResponse.setParticipationRuleSatisfied(rulesPassed);
			if("OR".equals(operand)){
				if (minNumberOfEEsRulesPassed || minPercentOfEEsRulesPassed) {
					rulesPassed = true;
				}
			}else {
				if (minNumberOfEEsRulesPassed && minPercentOfEEsRulesPassed) {
					rulesPassed = true;
				}
			}
			
			
			participationRuleResponse.setParticipationRuleSatisfied(rulesPassed);
			
			if(!rulesPassed && !minNumberOfEEsRulesPassed){
				participationRuleResponse.addFailureReason("Minimum number of enrolled EEs requried:"+minNumberOfEEs+". Actual number of EEs enrolled:"+participationRuleFact.getNumberOfEnrolled()+".");
			}

			if(!rulesPassed && !minPercentOfEEsRulesPassed){
				participationRuleResponse.addFailureReason("Minimum percent of enrolled EEs requried:"+(minPercentOfEEs*100)+"%. Actual percent of EEs enrolled: "+(percentOfEesEnrolled*100)+"%.");
			}
		}else{
			participationRuleResponse.setParticipationRuleSatisfied(false);
			participationRuleResponse.addFailureReason("No participation rule found for the input !!");
		}
		
		participationRuleResponse.setRuleFired(agendaEventListener.matchsToString());
		participationRuleResponse.setStatus(STATUS.SUCCESS);
		participationRuleResponse.endExecution();
		
		return participationRuleResponse;


	}
	
	public CarrierQuestionsRuleResponse executeCarrierQuestion(CarrierQuestionFact carrierQuestionFact) {
		KieSession kSession = RulesLoader.CARRIER_QUESTIONS_RULE_SESSION;
		CarrierQuestionsRuleResponse carrierQuestionsRuleResponse = new CarrierQuestionsRuleResponse();
		TrackingAgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
		carrierQuestionsRuleResponse.startExecution();
//		KieRuntimeLogger logger2 = KieServices.Factory.get().getLoggers().newFileLogger(kSession, "/Users/ssingh/Documents/workspace/poc/logs/carrier-questions.log");
		kSession.insert(carrierQuestionFact);
		kSession.fireAllRules();
		String questionsList = carrierQuestionFact.getQuestionsList();
		List<String> questions = Arrays.asList(questionsList.split(","));
		carrierQuestionsRuleResponse.setQuestions(questions);
		carrierQuestionsRuleResponse.setStatus(STATUS.SUCCESS);
		carrierQuestionsRuleResponse.setRuleFired(agendaEventListener.matchsToString());
		carrierQuestionsRuleResponse.endExecution();
//		logger2.close();
		return carrierQuestionsRuleResponse;
	}

}
