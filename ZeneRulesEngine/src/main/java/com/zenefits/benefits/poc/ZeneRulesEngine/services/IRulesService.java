/**
 * 
 */
package com.zenefits.benefits.poc.ZeneRulesEngine.services;

import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleFact;
import com.zenefits.benefits.poc.ZeneRulesEngine.models.ParticipationRuleResponse;

/**
 * @author ssingh
 *
 */
public interface IRulesService {
	public ParticipationRuleResponse executeParticipationRule(ParticipationRuleFact participationRuleFact);

}
