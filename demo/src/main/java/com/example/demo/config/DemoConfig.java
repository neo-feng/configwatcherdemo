package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ConfigurationProperties(prefix = "bean")
@ComponentScan()
public class DemoConfig {

    private String message = "a message that can be changed live";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}