/**
 * 
 */
package com.zenefits.benefits.poc.ZeneRulesEngine.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssingh
 *
 */
public class CarrierQuestionsRuleResponse extends Response{
	
	private List<String> questions = new ArrayList<String>();

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
	
	public void addQuestions(String question){
		this.questions.add(question);
	}
	
}
