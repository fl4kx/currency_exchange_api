package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.CurrencyExchangeDto;
import com.sparta.currency_user.dto.CurrencyExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.repository.CurrencyExchangeRepository;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    public CurrencyExchangeResponseDto exchange(Long userId, Long currencyId, CurrencyExchangeDto requestDto) {

        User user = userRepository.findUserByIdOrElseThrow(userId);

        Currency findCurrency = currencyRepository.findCurrencyByIdOrElseThrow(currencyId);

        UserCurrency userCurrency = new UserCurrency(
                requestDto.getBeforeExchange(),
                requestDto.getBeforeExchange().divide(findCurrency.getExchangeRate(), 2, RoundingMode.HALF_UP),
                "Normal",
                user,
                findCurrency
        );

        currencyExchangeRepository.save(userCurrency);

        return new CurrencyExchangeResponseDto(userCurrency.getAfterExchange(), userCurrency.getStatus());
    }


}
