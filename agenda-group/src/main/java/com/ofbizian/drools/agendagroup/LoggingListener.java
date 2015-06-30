package com.ofbizian.drools.agendagroup;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingListener extends DefaultAgendaEventListener implements AgendaEventListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingListener.class);

    @Override
    public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
        LOGGER.info("Match agendaGroupPopped: " + event.getAgendaGroup().getName());

    }

    @Override
    public void agendaGroupPushed(AgendaGroupPushedEvent event) {
        LOGGER.info("Match agendaGroupPushed: " + event.getAgendaGroup().getName());
    }


    @Override
	public void matchCreated(MatchCreatedEvent event) {
		super.matchCreated(event);
		LOGGER.info("Match created: " + event.getMatch().getRule().getName());
	}

	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		super.beforeMatchFired(event);
    }

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		super.afterMatchFired(event);
		LOGGER.info("After match fired: " + event.getMatch().getRule().getName());
	}
}
