package com.mrkid.logstash;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * User: xudong
 * Date: 10/13/16
 * Time: 1:42 PM
 */
@SpringBootApplication
@EnableScheduling
public class Application {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(Application.class, args);
    }
}



