package com.zenefits.benefits.poc.ZeneRulesEngine.models;

public class CarrierMetadata {
	private String name;
	private String state;
	private Integer groupSize;
	private Double minEEs;
	
	public Double getMinEEs() {
		return minEEs;
	}

	public void setMinEEs(Double minEEs) {
		this.minEEs = minEEs;
	}




	private boolean excludeEEWithValidWaivers;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(Integer groupSize) {
		this.groupSize = groupSize;
	}




	public boolean isExcludeEEWithValidWaivers() {
		return excludeEEWithValidWaivers;
	}




	public void setExcludeEEWithValidWaivers(boolean excludeEEWithValidWaivers) {
		this.excludeEEWithValidWaivers = excludeEEWithValidWaivers;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
