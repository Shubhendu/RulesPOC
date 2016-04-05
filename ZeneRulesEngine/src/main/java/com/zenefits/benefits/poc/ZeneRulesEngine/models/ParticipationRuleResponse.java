/**
 * 
 */
package com.zenefits.benefits.poc.ZeneRulesEngine.models;

import java.util.ArrayList;

/**
 * @author ssingh
 *
 */
public class ParticipationRuleResponse extends Response {
	
	private Boolean participationRuleSatisfied;
	private ArrayList<String> failureReasons = new ArrayList<String>();
	
	public Boolean getParticipationRuleSatisfied() {
		return participationRuleSatisfied;
	}
	public void setParticipationRuleSatisfied(Boolean participationRuleSatisfied) {
		this.participationRuleSatisfied = participationRuleSatisfied;
	}
	public ArrayList<String> getFailureReasons() {
		return failureReasons;
	}
	public void setFailureReasons(ArrayList<String> failureReasons) {
		this.failureReasons = failureReasons;
	}
	
	public void addFailureReason(String failureReason){
		this.failureReasons.add(failureReason);
	}
	
	
	
	

}
