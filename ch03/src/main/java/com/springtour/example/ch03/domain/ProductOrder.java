package com.springtour.example.ch03.domain;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ProductOrder {

    private final BigDecimal orderAmount;
    private final LocalDateTime orderAt;
    private final String buyerName;

    public ProductOrder(BigDecimal orderAmount, LocalDateTime orderAt, String buyerName) {
        if (orderAmount == null || orderAt == null || !StringUtils.hasLength(buyerName)) {
            throw new IllegalArgumentException("One of args is null");
        }

        this.orderAmount = orderAmount;
        this.orderAt = orderAt;
        this.buyerName = buyerName;
    }
}
