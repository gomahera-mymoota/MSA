package com.springtour.example.ch03.example02;

import com.springtour.example.ch03.domain.format.Formatter;
import com.springtour.example.ch03.example02.format.LocalDateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
public class SpringBean02Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBean02Application.class);

//        Formatter<LocalDateTime> formatter = ctx.getBean("localDateTimeFormatter", Formatter.class);
        Formatter<LocalDateTime> formatter = ctx.getBean("localDateTimeFormatter", LocalDateTimeFormatter.class);
        var date = formatter.of(LocalDateTime.of(2024, 1, 19, 23, 59, 59));

        log.info("Date : " + date);

        ctx.close();
    }

}
