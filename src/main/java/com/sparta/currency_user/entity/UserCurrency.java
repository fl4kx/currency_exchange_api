package com.sparta.currency_user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@Table (name = "user_currency")
public class UserCurrency extends Date {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal beforeExchange;

    private BigDecimal afterExchange;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public UserCurrency(BigDecimal beforeExchange, BigDecimal afterExchange, String status, User user, Currency currency) {
        this.beforeExchange = beforeExchange;
        this.afterExchange = afterExchange;
        this.status = status;
        this.user = user;
        this.currency = currency;
    }

    public UserCurrency() {

    }
}
