package com.mishkurov.loggers;

import com.mishkurov.Event;

import java.util.Collection;

/**
 * @author Anton_Mishkurov
 */
public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event msg) {

//        loggers.stream().forEach(EventLogger::logEvent(msg));

        for (EventLogger logger : loggers) {
            logger.logEvent(msg);
        }
    }
}
