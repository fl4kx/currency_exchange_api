package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.UserCurrency;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
public class ExchangeResponseDto {

    private String userName;

    private String status;

    private String symbol;

    private BigDecimal beforeExchange;

    private BigDecimal afterExchange;

    private Timestamp created_at;

    private Timestamp modified_at;

    public ExchangeResponseDto(UserCurrency exchange) {
        this.userName = exchange.getUser().getName();
        this.status = exchange.getStatus();
        this.symbol = exchange.getCurrency().getSymbol();
        this.beforeExchange = exchange.getBeforeExchange();
        this.afterExchange = exchange.getAfterExchange();
        this.created_at = exchange.getCreatedAt();
        this.modified_at = exchange.getModifiedAt();
    }
}
