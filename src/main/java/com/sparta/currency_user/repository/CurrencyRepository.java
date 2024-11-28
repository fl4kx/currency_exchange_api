package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findCurrencyById(Long id);

    default Currency findCurrencyByIdOrElseThrow(Long id) {
        return findCurrencyById(id).orElseThrow(()-> new IllegalArgumentException("통화를 찾을 수 없습니다."));
    }
}
