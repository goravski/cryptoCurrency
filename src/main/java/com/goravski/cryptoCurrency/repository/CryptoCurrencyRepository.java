package com.goravski.cryptoCurrency.repository;

import com.goravski.cryptoCurrency.model.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    @Query("SELECT cr FROM CryptoCurrency cr WHERE cr.id = ?1 AND cr.saved = (SELECT MAX(cr.saved) FROM CryptoCurrency cr WHERE cr.id = ?1)")
    Optional<CryptoCurrency> findActualById(int cryptoId);
}

