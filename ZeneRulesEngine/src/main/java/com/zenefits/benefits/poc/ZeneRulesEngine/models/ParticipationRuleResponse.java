/**
 * 
 */
package com.zenefits.benefits.poc.ZeneRulesEngine.models;

/**
 * @author ssingh
 *
 */
public class ParticipationRuleResponse {
	
	private Boolean participationRuleSatisfied;
	private String failureReason;
	
	public Boolean getParticipationRuleSatisfied() {
		return participationRuleSatisfied;
	}
	public void setParticipationRuleSatisfied(Boolean participationRuleSatisfied) {
		this.participationRuleSatisfied = participationRuleSatisfied;
	}
	public String getFailureReason() {
		return failureReason;
	}
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
	
	
	
	

}
