package com.mishkurov.loggers;

import com.mishkurov.Event;

/**
 * @author Anton_Mishkurov
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event msg) {
        System.out.println(msg);
    }
}
