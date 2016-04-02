/**
 * 
 */
package com.zenefits.benefits.poc.ZeneRulesEngine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleFact;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.CarrierQuestionFact;

import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleResponse;
import com.zenefits.benefits.poc.ZeneRulesEngine.services.IRulesService;

/**
 * @author ssingh
 *
 */
@Controller
public class RulesController {

	@Autowired
	private IRulesService ruleService;
	
	@RequestMapping(value = "/participation-rules",method=RequestMethod.POST)
	@ResponseBody
	public ParticipationRuleResponse getMainPage(@RequestBody ParticipationRuleFact participationRuleFact){
		return ruleService.executeParticipationRule(participationRuleFact);
	}
	@RequestMapping(value = "/carrier-questions",method=RequestMethod.POST)
	@ResponseBody
	public String getMainPage(@RequestBody CarrierQuestionFact carrierQuestionFact){
		return ruleService.executeCarrierQuestion(carrierQuestionFact);
	}

	@RequestMapping(value = "/health-check",method=RequestMethod.GET)
	@ResponseBody
	public String healthStatus(){
		return "Welcome to the world of RULES ENGINE !!";
	}
	
}
