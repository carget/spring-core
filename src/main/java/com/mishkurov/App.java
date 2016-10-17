package com.mishkurov;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author Anton_Mishkurov
 */
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
//        String message = event.toString().replaceAll(String.valueOf(client.getId()), client.getFullName());
    }

    public static void main(String[] args) {
//        App app = new App();
//        app.client = new Client(1, "John Smith");
//        app.eventLogger = new ConsoleEventLogger();

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean(App.class);
        Event event = (Event) context.getBean("event");
        event.setMessage("Some event for error");
        app.logEvent(EventType.ERROR, event);
        event = (Event) context.getBean("event");
        event.setMessage("event info 2");
        app.logEvent(EventType.INFO, event);
        context.close();
    }
}
