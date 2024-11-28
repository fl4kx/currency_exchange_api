package com.sparta.currency_user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Date {

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @CreatedDate
    @Column(name = "modified_at")
    private Timestamp modifiedAt;
}
