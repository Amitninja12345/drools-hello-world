package com.ofbizian.drools.agendagroup;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

public class Main {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession ksession = kieContainer.newKieSession();
        ksession.addEventListener(new LoggingListener());

        ksession.insert(new Person("One", "Last"));

        ksession.fireAllRules(new AgendaFilter() {
            @Override
            public boolean accept(Match match) {
                if (match.getRule().getName().toLowerCase().endsWith("test")) {
                    return false;
                } else {
                    return true;
                }
            }
        });

        ksession.dispose();
    }

}