package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.UserCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRepository extends JpaRepository<UserCurrency, Long> {

    Optional<UserCurrency> findExchangeById(Long id);

    default UserCurrency findExchangeByIdOrElseThrow(Long id) {
        return findExchangeById(id).orElseThrow(() -> new IllegalArgumentException("환전 신청 내역을 찾을 수 없습니다."));
    }


}
