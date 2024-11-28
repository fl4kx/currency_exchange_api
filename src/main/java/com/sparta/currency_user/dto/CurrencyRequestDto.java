package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    private String currencyName;
    private BigDecimal exchangeRate;
    private String symbol;
    private User user;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol,
                this.user
        );
    }
}
