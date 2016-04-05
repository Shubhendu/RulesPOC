package com.zenefits.benefits.poc.ZeneRulesEngine;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class RulesLoader implements ApplicationListener<ContextRefreshedEvent> {
	public static KieSession PARTICIPATION_RULE_SESSION;
	public static KieSession CARRIER_QUESTIONS_RULE_SESSION;

	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		try {
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kieContainer = kieServices.getKieClasspathContainer();
			System.out.println("===== Loading Participation Rules ==== ");
			PARTICIPATION_RULE_SESSION = kieContainer.newKieSession("participation-rules");
			PARTICIPATION_RULE_SESSION.addEventListener( new DebugAgendaEventListener() );
			PARTICIPATION_RULE_SESSION.addEventListener( new DebugRuleRuntimeEventListener() );
			System.out.println("===== Loading Carrier Rules ==== ");
			CARRIER_QUESTIONS_RULE_SESSION = kieContainer.newKieSession("carrier-questions-rules");
			CARRIER_QUESTIONS_RULE_SESSION.addEventListener( new DebugAgendaEventListener() );
			CARRIER_QUESTIONS_RULE_SESSION.addEventListener( new DebugRuleRuntimeEventListener() );
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
