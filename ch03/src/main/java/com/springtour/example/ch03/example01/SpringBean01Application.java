package com.springtour.example.ch03.example01;

import com.springtour.example.ch03.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Locale;

@Slf4j
@SpringBootApplication
public class SpringBean01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBean01Application.class, args);

		var defaultPriceUnit = ctx.getBean("priceUnit", PriceUnit.class);
		log.info("Price #1 : {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

		var wonPriceUnit = ctx.getBean("wonPriceUnit", PriceUnit.class);
		log.info("Price #2 : {}", wonPriceUnit.format(BigDecimal.valueOf(1000)));

		ctx.close();
	}

	@Bean(name = "priceUnit")
	public PriceUnit dollarPriceUnit() {
		return new PriceUnit(Locale.US);
	}

	@Bean
	public PriceUnit wonPriceUnit() {
		return new PriceUnit(Locale.KOREA);
	}

}
