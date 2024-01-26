package com.springtour.example.ch03.example03;

import com.springtour.example.ch03.domain.ProductOrder;
import com.springtour.example.ch03.example03.service.OrderPrinter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
public class SpringBean03Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBean03Application.class);

        var printer = ctx.getBean(OrderPrinter.class);
        var order = new ProductOrder(BigDecimal.valueOf(1000), LocalDateTime.now(), "iceman4u");

        try (OutputStream os = System.out) {
            printer.print(os, order);
            log.info("Output : {} -> {}", os, order);
        } catch (IOException ioe) {
            log.error("Error to print", ioe);
        }

        ctx.close();
    }

}
