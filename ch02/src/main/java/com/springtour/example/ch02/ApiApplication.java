package com.springtour.example.ch02;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Ch02Application.class, args);

        Environment env = ctx.getBean(Environment.class);
        var portValue = env.getProperty("server.port");
        log.info("Customized Port : {}", portValue);

        var beanNames = ctx.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(name -> log.info("Bean Name : {}", name));
    }
}
