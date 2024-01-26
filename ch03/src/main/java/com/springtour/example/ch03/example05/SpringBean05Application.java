package com.springtour.example.ch03.example05;

import com.springtour.example.ch03.domain.format.DateFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
public class SpringBean05Application {

    public static void main(String[] args) throws InterruptedException {
        var appCtx = SpringApplication.run(SpringBean05Application.class, args);
        var taskExecutor = appCtx.getBean(ThreadPoolTaskExecutor.class);
        final String dateString = "2024-01-21T23:59:59.-09:00";

        for (int i = 0; i < 100; i++) {
            taskExecutor.submit(() -> {
                try {
                    var formatter = appCtx.getBean("singletonDateFormatter", DateFormatter.class);
                    log.info("Date : {}, hashCode : {}", formatter.parse(dateString), formatter.hashCode());
                } catch (Exception e) {
                    log.error("error to parse", e);
                }
            });
        }

        TimeUnit.SECONDS.sleep(5);
        appCtx.close();
    }

    @Bean
//    @Scope("prototype")
    public DateFormatter singletonDateFormatter() {
        return new DateFormatter("yyyy-MM-dd'T'HH:mm:ss");
    }
}
