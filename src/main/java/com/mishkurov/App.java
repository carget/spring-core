package com.mishkurov;

import com.mishkurov.javaconfig.AppConfig;
import com.mishkurov.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Anton_Mishkurov
 */
@Component
public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event event) {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        App app = context.getBean(App.class);
        Event event = (Event) context.getBean("event");
        event.setMessage("Some event for error");
        app.logEvent(EventType.ERROR, event);
        event = (Event) context.getBean("event");
        event.setMessage("event info 2");
        app.logEvent(EventType.INFO, event);
    }
}
