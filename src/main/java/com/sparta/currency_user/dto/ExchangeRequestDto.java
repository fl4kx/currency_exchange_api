package com.sparta.currency_user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExchangeRequestDto {

    private BigDecimal beforeExchange;

    public ExchangeRequestDto(BigDecimal beforeExchange) {
        this.beforeExchange = beforeExchange;
    }
}
