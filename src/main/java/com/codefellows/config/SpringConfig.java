package com.codefellows.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    //TODO: Alter the Spring configuration here so that the application uses GcpConfigProvider.

    @Bean
    public IConfigProvider configProvider() {
        return new YamlConfigProvider();
    }
}
