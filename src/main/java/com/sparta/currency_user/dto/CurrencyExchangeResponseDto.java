package com.sparta.currency_user.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyExchangeResponseDto {

    private BigDecimal afterExchange;

    private String status;

    public CurrencyExchangeResponseDto(BigDecimal afterExchange, String status) {
        this.afterExchange = afterExchange;
        this.status = status;
    }
}
