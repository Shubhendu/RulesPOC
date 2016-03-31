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
	
	@RequestMapping(value = "/api",method=RequestMethod.POST)
	@ResponseBody
	public ParticipationRuleResponse getMainPage(@RequestBody ParticipationRuleFact participationRuleFact){
		System.out.println("API is up and running !!");
		return ruleService.executeParticipationRule(participationRuleFact);
	}

	
}
