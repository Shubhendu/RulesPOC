package com.zenefits.benefits.poc.ZeneRulesEngine.services;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.zenefits.benefits.poc.ZeneRulesEngine.RulesLoader;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.CarrierQuestionFact;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleFact;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleResponse;

@Service
public class IRuleServiceImpl implements IRulesService{
	
	public ParticipationRuleResponse executeParticipationRule(ParticipationRuleFact participationRuleFact) {
		KieSession kSession = RulesLoader.PARTICIPATION_RULE_SESSION;
		kSession.insert(participationRuleFact);
		kSession.fireAllRules();
		ParticipationRuleResponse participationRuleResponse = new ParticipationRuleResponse();
		Integer minNumberOfEEs = participationRuleFact.getMinimumNumberOfEEs();
		Double minPercentOfEEs = participationRuleFact.getMinimumPercentageOfEEs();
		boolean rulesAvailable = false;
		boolean rulesPassed = false;
		
		if (minNumberOfEEs != null) {
			rulesAvailable = true;
			if(participationRuleFact.getNumberOfEnrolled() >= minNumberOfEEs){
				rulesPassed = true;
			}else{
				rulesPassed = false;
				participationRuleResponse.addFailureReason("Minimum number of enrolled EEs requried: "+minNumberOfEEs+" Actual number of EEs enrolled: "+participationRuleFact.getNumberOfEnrolled());
			}
		}
		
		if (minPercentOfEEs != null) {
			rulesAvailable = true;
			double eeEnrolled = participationRuleFact.getNumberOfEnrolled().doubleValue()/participationRuleFact.getGroupSize().doubleValue();
			if ( eeEnrolled >= minPercentOfEEs) {
				rulesPassed = true;
			}else{
				rulesPassed = false;
				participationRuleResponse.addFailureReason("Minimum percent of enrolled EEs requried: "+(minPercentOfEEs*100)+"% Actual percent of EEs enrolled: "+(eeEnrolled*100)+"%");
			}
		}
		
		if(rulesAvailable){
			participationRuleResponse.setParticipationRuleSatisfied(rulesPassed);
		}else{
			participationRuleResponse.setParticipationRuleSatisfied(false);
			participationRuleResponse.addFailureReason("No participation rule found for the input !!");
		}
		
		return participationRuleResponse;
		
		
	}
	
	public String executeCarrierQuestion(CarrierQuestionFact carrierQuestionFact) {
		KieSession kSession = RulesLoader.CARRIER_QUESTIONS_RULE_SESSION;
		kSession.insert(carrierQuestionFact);
		kSession.fireAllRules();
		String questionsList = carrierQuestionFact.getQuestionsList();
		return questionsList;
	}

}
