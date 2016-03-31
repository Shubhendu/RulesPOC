package com.zenefits.benefits.poc.ZeneRulesEngine.models;

public class ParticipationRuleFact {
	private String carrierName;
	private String carrierState;
	private String lineOfCoverage;
	private String contributionType;
	private String planGroup;
	private int groupSize;
	private int numberOfEnrolled;
	private Boolean participationRuleSatisfied;
	private String failureReason;
	
	public ParticipationRuleFact(String carrierName, String carrierState, String lineOfCoverage, 
			String contributionType, String planGroup, int groupSize, int numberOfEnrolled) {
		this.setCarrierName(carrierName);
		this.setCarrierState(carrierState);
		this.setLineOfCoverage(lineOfCoverage);
		this.setContributionType(contributionType);
		this.setPlanGroup(planGroup);
		this.setGroupSize(groupSize);
		this.setNumberOfEnrolled(numberOfEnrolled);
		this.setParticipationRuleSatisfied(false);
		this.setFailureReason("");
	}

	public String getCarrierName() {
		return carrierName;
	}


	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


	public String getCarrierState() {
		return carrierState;
	}


	public void setCarrierState(String carrierState) {
		this.carrierState = carrierState;
	}


	public String getLineOfCoverage() {
		return lineOfCoverage;
	}


	public void setLineOfCoverage(String lineOfCoverage) {
		this.lineOfCoverage = lineOfCoverage;
	}


	public String getContributionType() {
		return contributionType;
	}


	public void setContributionType(String contributionType) {
		this.contributionType = contributionType;
	}


	public String getPlanGroup() {
		return planGroup;
	}


	public void setPlanGroup(String planGroup) {
		this.planGroup = planGroup;
	}


	public int getGroupSize() {
		return groupSize;
	}


	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}


	public int getNumberOfEnrolled() {
		return numberOfEnrolled;
	}


	public void setNumberOfEnrolled(int numberOfEnrolled) {
		this.numberOfEnrolled = numberOfEnrolled;
	}
	public boolean isParticipationRuleSatisfied() {
		return participationRuleSatisfied;
	}

	public void setParticipationRuleSatisfied(boolean participationRuleSatisfied) {
		this.participationRuleSatisfied = participationRuleSatisfied;
	}
	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
}
