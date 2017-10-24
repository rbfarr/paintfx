package com.codefellows.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public IConfigProvider configProvider() {
        return new YamlConfigProvider();
    }
}
