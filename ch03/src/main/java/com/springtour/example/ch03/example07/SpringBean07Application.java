package com.springtour.example.ch03.example07;

import com.springtour.example.ch03.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Locale;

@Slf4j
@SpringBootApplication
public class SpringBean07Application {

    public static void main(String[] args) {
        var appCtx = SpringApplication.run(SpringBean07Application.class);
        var priceUnit = appCtx.getBean(PriceUnit.class);

        log.info("Locale in PriceUnit : {}", priceUnit.getLocale().toString());

        appCtx.close();
    }

    @Bean
    @Primary
    public PriceUnit primaryPriceUnit() {
        return new PriceUnit(Locale.US);
    }

    @Bean
    public PriceUnit secondaryPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }

}
