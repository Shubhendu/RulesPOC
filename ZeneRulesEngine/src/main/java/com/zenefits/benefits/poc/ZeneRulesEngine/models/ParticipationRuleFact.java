package com.zenefits.benefits.poc.ZeneRulesEngine.models;

public class ParticipationRuleFact {
	private String carrierName;
	private String carrierState;
	private String lineOfCoverage;
	private String contributionType;
	private String planGroup;
	private Integer groupSize;
	private Integer numberOfEnrolled;
	
	private Integer minimumNumberOfEEs;
	private Double minimumPercentageOfEEs;
	private String operand;
	
	public Integer getMinimumNumberOfEEs() {
		return minimumNumberOfEEs;
	}
	public void setMinimumNumberOfEEs(Integer minimumNumberOfEEs) {
		this.minimumNumberOfEEs = minimumNumberOfEEs;
	}
	public Double getMinimumPercentageOfEEs() {
		return minimumPercentageOfEEs;
	}
	public void setMinimumPercentageOfEEs(Double minimumPercentageOfEEs) {
		this.minimumPercentageOfEEs = minimumPercentageOfEEs;
	}
	
	public ParticipationRuleFact(){
		
	}
	
	public ParticipationRuleFact(String carrierName, String carrierState, String lineOfCoverage, String contributionType, String planGroup, Integer groupSize, Integer numberOfEnrolled) {
		this.setCarrierName(carrierName);
		this.setCarrierState(carrierState);
		this.setLineOfCoverage(lineOfCoverage);
		this.setContributionType(contributionType);
		this.setPlanGroup(planGroup);
		this.setGroupSize(groupSize);
		this.setNumberOfEnrolled(numberOfEnrolled);
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


	public Integer getGroupSize() {
		return groupSize;
	}


	public void setGroupSize(Integer groupSize) {
		this.groupSize = groupSize;
	}


	public Integer getNumberOfEnrolled() {
		return numberOfEnrolled;
	}


	public void setNumberOfEnrolled(Integer numberOfEnrolled) {
		this.numberOfEnrolled = numberOfEnrolled;
	}
	public String getOperand() {
		return operand;
	}
	public void setOperand(String operand) {
		this.operand = operand;
	}
	
}
