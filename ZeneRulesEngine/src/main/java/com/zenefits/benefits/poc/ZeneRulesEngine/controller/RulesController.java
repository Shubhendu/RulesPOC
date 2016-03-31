/**
 * 
 */
package com.zenefits.benefits.poc.ZeneRulesEngine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ssingh
 *
 */
@Controller
public class RulesController {

	@RequestMapping(value = "/api",method=RequestMethod.GET)
	@ResponseBody
	public String getMainPage(){
		return "API is up and running !!";
	}

	
}
