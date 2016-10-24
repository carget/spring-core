package com.mishkurov.javaconfig;

import com.mishkurov.App;
import com.mishkurov.Client;
import com.mishkurov.EventType;
import com.mishkurov.loggers.EventLogger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton_Mishkurov
 */
@ComponentScan("com.mishkurov")
@Configuration
public class OtherConfig {

    @Bean("loggerMap")
    public Map<EventType, EventLogger> loggerMap(
            @Qualifier("consoleEventLogger") EventLogger logger1,
            @Qualifier("combinedEventLogger") EventLogger logger2) {
        Map<EventType, EventLogger> loggerMap = new HashMap<>();
        loggerMap.put(EventType.INFO, logger1);
        loggerMap.put(EventType.ERROR, logger2);
        return loggerMap;
    }

    @Bean("app")
    public App app(@Qualifier("client") Client client,
                   @Qualifier("cacheFileEventLogger") EventLogger logger,
                   @Qualifier("loggerMap") Map<EventType, EventLogger> loggerMap) {
        return new App(client, logger, loggerMap);
    }
}
