package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
import org.springframework.scheduling.annotation.EnableScheduling;

@Component
@EnableScheduling
public class DemoBean {

    @Autowired
    private DemoConfig config;

    @Scheduled(fixedDelay = 5000)
    public void hello() {
        System.out.println((new Date()).toString() + ": Now processing on " + config.getMessage());
    }
}