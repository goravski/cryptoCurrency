package com.goravski.cryptoCurrency.service;

import com.goravski.cryptoCurrency.model.CryptoCurrency;
import com.goravski.cryptoCurrency.repository.CryptoCurrencyRepository;
import com.goravski.cryptoCurrency.utils.CryptoSchedulerTicker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
public class CryptoCurrencyService {
    private final CryptoCurrencyRepository cryptoCurrencyRepository;
    private final CryptoSchedulerTicker ticker;

    @Autowired
    public CryptoCurrencyService(CryptoCurrencyRepository cryptoCurrencyRepository, CryptoSchedulerTicker ticker) {
        this.cryptoCurrencyRepository = cryptoCurrencyRepository;
        this.ticker = ticker;
    }

    @Scheduled(fixedRate = 60000 ) // every minute
    public void saveCryptoCurrency() {
        Stream.of(ticker.getCrypto()).forEach(crypto -> {
            cryptoCurrencyRepository.save(crypto);
            log.info("saved crypto: {}", crypto);
        });
    }

    public Optional<CryptoCurrency> getActualCrypto(String symbol) {
        return cryptoCurrencyRepository.findActualCrypto(symbol);
    }

}
