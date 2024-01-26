package com.springtour.example.ch02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch02Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Ch02Application.class);
        application.run(args);
    }
}
