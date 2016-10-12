package com.mishkurov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

/**
 * @author Anton_Mishkurov
 */
public class App {

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event){
//        String message = event.toString().replaceAll(String.valueOf(client.getId()), client.getFullName());
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
//        App app = new App();
//        app.client = new Client(1, "John Smith");
//        app.eventLogger = new ConsoleEventLogger();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean(App.class);
        Event event = (Event) context.getBean("event");
        event.setMessage("Some event for user 1");
        app.logEvent(event);
    }
}