package com.sparta.currency_user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CurrencyExchangeDto {

    private BigDecimal beforeExchange;

    public CurrencyExchangeDto(BigDecimal beforeExchange) {
        this.beforeExchange = beforeExchange;
    }
}
