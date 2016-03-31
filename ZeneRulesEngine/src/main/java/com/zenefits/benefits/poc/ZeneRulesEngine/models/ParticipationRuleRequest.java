package com.zenefits.benefits.poc.ZeneRulesEngine.models;

public class ParticipationRuleRequest {
	private String carrierName;
	private String carrierState;
	private String lineOfCoverage;
	private String contributionType;
	private String planGroup;
	private Integer groupSize;
	private Integer numberOfEnrolled;
	
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
	
	
	
}
