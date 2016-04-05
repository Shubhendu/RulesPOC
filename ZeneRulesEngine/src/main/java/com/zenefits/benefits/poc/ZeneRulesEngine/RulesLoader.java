package com.zenefits.benefits.poc.ZeneRulesEngine;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
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
			System.out.println("===== Loading Carrier Rules ==== ");
			CARRIER_QUESTIONS_RULE_SESSION = kieContainer.newKieSession("carrier-questions-rules");
			KieScanner kScanner = kieServices.newKieScanner( kieContainer );
			kScanner.start( 10000L );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
