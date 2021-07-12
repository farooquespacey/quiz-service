package com.spacey.qz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan({"com.spacey.qz"})
@Slf4j
public class Application {
	
    public static void main(String[] args) {
        log.info("Starting Application...");
        SpringApplication.run(Application.class, args);
    }
    
}
