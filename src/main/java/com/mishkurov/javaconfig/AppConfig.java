package com.mishkurov.javaconfig;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Anton_Mishkurov
 */
@Configuration
@Import({OtherConfig.class, LoggerConfig.class})
public class AppConfig {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(
                new ClassPathResource("client.properties"),
                new ClassPathResource("event.properties"),
                new ClassPathResource("logger.properties"));
        propertyPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        propertyPlaceholderConfigurer.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE);
        return propertyPlaceholderConfigurer;
    }
}
