package com.sparta.currency_user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateExchangeRequestDto {

    private String status;

    public UpdateExchangeRequestDto(String status) {
        this.status = status;
    }
}
