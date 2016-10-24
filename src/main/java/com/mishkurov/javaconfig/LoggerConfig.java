package com.mishkurov.javaconfig;

import com.mishkurov.Event;
import com.mishkurov.loggers.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton_Mishkurov
 */
@Configuration
public class LoggerConfig {

    @Bean(name = "consoleEventLogger")
    public ConsoleEventLogger consoleEventLogger() {
        return new ConsoleEventLogger();
    }

    @Bean(name = "fileEventLogger", initMethod = "init")
    public FileEventLogger fileEventLogger(@Value("${logger.file.name}") String fileName) {
        return new FileEventLogger(fileName);
    }

    //todo set parent bean
    @Bean(name = "cacheFileEventLogger", destroyMethod = "destroy")
    public CacheFileEventLogger cacheFileEventLogger(@Value("${logger.file.name}") String fileName,
                                                     @Value("${logger.cache.size}") Integer cacheSize) {
        return new CacheFileEventLogger(fileName, cacheSize);
    }

    @Bean(name = "event")
    @Scope("prototype")
    public Event event(@Value("${event.pattern}") String pattern) {
        return new Event(LocalDate.now(), DateTimeFormatter.ofPattern(pattern));
    }

    @Bean(name = "combinedEventLogger")
    public CombinedEventLogger combinedEventLogger(
            @Qualifier("consoleEventLogger") EventLogger logger1,
            @Qualifier("fileEventLogger") EventLogger logger2) {
        List<EventLogger> eventLoggers = new ArrayList<>();
        eventLoggers.add(logger1);
        eventLoggers.add(logger2);
        return new CombinedEventLogger(eventLoggers);
    }
}
