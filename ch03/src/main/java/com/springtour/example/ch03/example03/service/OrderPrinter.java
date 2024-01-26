package com.springtour.example.ch03.example03.service;

import com.springtour.example.ch03.domain.ProductOrder;
import com.springtour.example.ch03.domain.format.Formatter;
import com.springtour.example.ch03.domain.service.Printer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

@Service
public class OrderPrinter implements Printer<ProductOrder> {

    private Formatter<LocalDateTime> formatter;

    public OrderPrinter(@Qualifier("localDateTimeFormatter") Formatter<LocalDateTime> formatter) {
        this.formatter = formatter;
    }

    @Override
    public void print(OutputStream os, ProductOrder productOrder) throws IOException {
        String orderAt = formatter.of(productOrder.getOrderAt());

        os.write(orderAt.getBytes());
    }

}
