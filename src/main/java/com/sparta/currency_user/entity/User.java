package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserCurrency> userCurrency = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Currency>  currency = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {}
}