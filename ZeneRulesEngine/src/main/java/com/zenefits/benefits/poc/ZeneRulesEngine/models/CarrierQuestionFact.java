package com.zenefits.benefits.poc.ZeneRulesEngine.models;

public class CarrierQuestionFact {
	private String carrierName;
	private String carrierState;
	private String enrollmentFlow;
	private String lineOfCoverage;
	private String enrollmentType;
	private Integer groupSize;
	
	private String questionsList;
	
	
	public CarrierQuestionFact(){
		
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


	public Integer getGroupSize() {
		return groupSize;
	}


	public void setGroupSize(Integer groupSize) {
		this.groupSize = groupSize;
	}


	public String getEnrollmentFlow() {
		return enrollmentFlow;
	}
	public void setEnrollmentFlow(String enrollmentFlow) {
		this.enrollmentFlow = enrollmentFlow;
	}
	public String getEnrollmentType() {
		return enrollmentType;
	}
	public void setEnrollmentType(String enrollmentType) {
		this.enrollmentType = enrollmentType;
	}

	public String getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(String questionsList) {
		this.questionsList = questionsList;
	}
	
}
