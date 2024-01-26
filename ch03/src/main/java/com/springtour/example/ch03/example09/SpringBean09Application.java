package com.springtour.example.ch03.example09;

import com.springtour.example.ch03.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.Locale;

@Slf4j
@SpringBootApplication
public class SpringBean09Application {

    public static void main(String[] args) {
        var appCtx = SpringApplication.run(SpringBean09Application.class);

        log.info("------ Done to initialize spring beans");

        var priceUnit = appCtx.getBean("lazyPriceUnit", PriceUnit.class);

        log.info("Locale in PriceUnit : {}", priceUnit.getLocale().toString());

        appCtx.close();
    }

    @Bean
    @Lazy
    public PriceUnit lazyPriceUnit() {
        log.info("initialize lazyPriceUnit");

        return new PriceUnit(Locale.US);
    }
}
