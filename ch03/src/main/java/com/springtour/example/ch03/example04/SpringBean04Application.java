package com.springtour.example.ch03.example04;

import com.springtour.example.ch03.config.DateFormatter;
import com.springtour.example.ch03.config.ServerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.springtour.example.ch03.config"},
        basePackageClasses = {ServerConfig.class})
public class SpringBean04Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBean04Application.class);

        var formatter01 = ctx.getBean("dateFormatter", DateFormatter.class);
        var dateString01 = formatter01.of(new Date());

        log.info("Date : {}", dateString01);

        var formatter02 = ctx.getBean("defaultDateFormatter", DateFormatter.class);
        var dateString02 = formatter02.of(new Date());

        log.info("Date : {}", dateString02);

        var formatter03 = ctx.getBean("secondDateFormatter", DateFormatter.class);
        var dateString03 = formatter03.of(new Date());

        log.info("Date : {}", dateString03);

        ctx.close();
    }

}
