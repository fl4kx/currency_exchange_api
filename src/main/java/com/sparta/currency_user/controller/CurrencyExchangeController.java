package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.CurrencyExchangeDto;
import com.sparta.currency_user.dto.CurrencyExchangeResponseDto;
import com.sparta.currency_user.service.CurrencyExchangeService;
import com.sparta.currency_user.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/exchange")
@RestController
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @PostMapping("/{userId}/{currencyId}")
    public ResponseEntity<CurrencyExchangeResponseDto> exchange(
            @PathVariable Long userId,
            @PathVariable Long currencyId,
            @RequestBody CurrencyExchangeDto currencyExchangeDto
    ) {
        CurrencyExchangeResponseDto responseDto = currencyExchangeService.exchange(userId, currencyId, currencyExchangeDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

}
