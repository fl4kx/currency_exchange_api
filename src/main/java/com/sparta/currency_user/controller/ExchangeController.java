package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.dto.UpdateExchangeRequestDto;
import com.sparta.currency_user.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/exchange")
@RestController
public class ExchangeController {

    private final ExchangeService exchangeService;

    // currencyId 는 Request Body 에 넣어도 괜찮지 않을까?
    @PostMapping("/{userId}/{currencyId}")
    public ResponseEntity<Void> create(
            @PathVariable Long userId,
            @PathVariable Long currencyId,
            @RequestBody ExchangeRequestDto currencyExchangeDto
    ) {
        exchangeService.create(userId, currencyId, currencyExchangeDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(exchangeService.findById(id), HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody UpdateExchangeRequestDto requestDto) {

        exchangeService.updateById(id, requestDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        exchangeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
