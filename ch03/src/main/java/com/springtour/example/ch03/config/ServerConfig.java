package com.springtour.example.ch03.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ServerConfig {

    @Bean
    public String datePattern() {
        return "yyyy-MM-dd'T'HH:mm:ss";
    }

    // 같은 설정 클래스 내에서 정의된 스프링 빈들끼리 의존성 주입: 메서드를 그대로 사용
    @Bean
    public DateFormatter defaultDateFormatter() {
        log.info("ServerConfig.defaultDateFormatter : {}", datePattern().hashCode());

        return new DateFormatter(datePattern() + "[XXX]");
    }

    // 일반적인 스프링 의존성 주입
    @Bean
    public DateFormatter secondDateFormatter(String datepattern) {
        log.info("ServerConfig.secondDateFormatter : {}", datepattern);

        return new DateFormatter(datepattern);
    }
//    @Bean
//    public DateFormatter defaultDateFormatter(String pattern) {
//        log.info("ServerConfig.defaultDateFormatter : {}", pattern.hashCode());
//        return new DateFormatter(pattern + "[XXX]");
//    }

}
