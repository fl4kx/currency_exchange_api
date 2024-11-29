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

/**
 * {@code ExchangeController} 는 {@code /exchange} 로 들어오는 환전 요청을 처리하는 Controller 입니다.
 *
 */
@RequiredArgsConstructor
@RequestMapping("/exchange")
@RestController
public class ExchangeController {

    /**
     * 환전 로직을 처리하는 {@link ExchangeService} 객체를 주입받습니다.
     */
    private final ExchangeService exchangeService;

    /**
     * 환전 신청 데이터를 Path Variable, Request Body 로 받아
     *  신청 데이터 생성 로직을 호출하고 그 결과를 반환하는 메서드입니다.
     *
     * @param userId 요청을 보낸 사용자 식별값
     * @param currencyId 환전하고자 하는 통화 식별값
     * @param exchangeRequestDto 환전 신청 데이터를 담은 DTO
     * @return http status code
     */
    @PostMapping("/{userId}/{currencyId}")
    public ResponseEntity<Void> create(
            @PathVariable Long userId,
            @PathVariable Long currencyId,
            @RequestBody ExchangeRequestDto exchangeRequestDto
    ) {
        exchangeService.create(userId, currencyId, exchangeRequestDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * {@code Path Variable} 로 받은 {@code id} 값을 담아
     * 환전 신청 조회 로직을 호출하고 그 결과를 반환하는 메서드입니다.
     *
     * @param id 환전 신청 id
     * @return {@link ExchangeResponseDto} 타입의 데이터 및 http status code
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExchangeResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(exchangeService.findById(id), HttpStatus.OK);

    }


    /**
     * 환전 신청 id와 {@link UpdateExchangeRequestDto} 를 받아
     * 환전 신청 상태 변경 로직을 호출하고 그 결과를 반환하는 메서드입니다.
     *
     * @param id 수정할 환전 신청 id
     * @param requestDto 수정 데이터를 담은 DTO
     * @return http status code
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody UpdateExchangeRequestDto requestDto) {

        exchangeService.updateById(id, requestDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 환전 신청 id 를 받아 삭제하는 로직을 호출하고 그 결과를 반환하는 메서드입니다.
     *
     * @param id 삭제할 환전 신청 id
     * @return http status code
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        exchangeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
