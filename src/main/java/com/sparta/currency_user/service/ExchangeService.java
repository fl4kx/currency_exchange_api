package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.dto.UpdateExchangeRequestDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.repository.ExchangeRepository;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    @Transactional
    public void create(Long userId, Long currencyId, ExchangeRequestDto requestDto) {

        User findUser = userRepository.findUserByIdOrElseThrow(userId);

        Currency findCurrency = currencyRepository.findCurrencyByIdOrElseThrow(currencyId);

        UserCurrency userCurrency = new UserCurrency(
                requestDto.getBeforeExchange(),
                requestDto.getBeforeExchange().divide(findCurrency.getExchangeRate(), 2, RoundingMode.HALF_UP),
                "Normal",
                findUser,
                findCurrency
        );

        exchangeRepository.save(userCurrency);
    }


    public ExchangeResponseDto findById(Long exchangeId) {
        UserCurrency findExchange =  exchangeRepository.findExchangeByIdOrElseThrow(exchangeId);

        return new ExchangeResponseDto(findExchange);
    }

    @Transactional
    public void updateById(Long id, UpdateExchangeRequestDto requestDto) {
        UserCurrency findExchange = exchangeRepository.findExchangeByIdOrElseThrow(id);

        findExchange.updateStatus(requestDto);

    }

    @Transactional
    public void deleteById(Long id) {
        UserCurrency findExchange = exchangeRepository.findExchangeByIdOrElseThrow(id);

        exchangeRepository.delete(findExchange);
    }
}
