/**
 * 
 */
package com.zenefits.benefits.poc.ZeneRulesEngine.models;

/**
 * @author ssingh
 *
 */
public class Response {
	public enum STATUS {
		SUCCESS("success"), FAILURE("failure");
		private final String value;

		private STATUS(final String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return getValue();
		}
	};

	private STATUS status;
	private String errorMessage;
	private Long executionTime;
	private Long startTime;
	private String ruleFired;

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public String getRuleFired() {
		return ruleFired;
	}
	
	public void setRuleFired(String ruleFired) {
		this.ruleFired = ruleFired;
	}
	public void startExecution() {
		this.startTime = System.currentTimeMillis();
	}

	public void endExecution() {
		this.executionTime = System.currentTimeMillis() - this.startTime;
	}

}
