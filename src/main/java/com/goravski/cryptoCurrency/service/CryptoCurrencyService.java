package com.goravski.cryptoCurrency.service;

import com.goravski.cryptoCurrency.model.CryptoCurrency;
import com.goravski.cryptoCurrency.model.UserActive;
import com.goravski.cryptoCurrency.repository.CryptoCurrencyRepository;
import com.goravski.cryptoCurrency.repository.UserActiveRepository;
import com.goravski.cryptoCurrency.utils.CryptoSchedulerTicker;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Getting query from repository, perform operations with data from database, redirect query to repository.
 */
@Service
@Log4j2
public class CryptoCurrencyService {
    private final CryptoCurrencyRepository cryptoCurrencyRepository;
    private final CryptoSchedulerTicker ticker;
    private final UserActiveRepository userActiveRepository;

    @Autowired
    public CryptoCurrencyService(CryptoCurrencyRepository cryptoCurrencyRepository, CryptoSchedulerTicker ticker, UserActiveRepository userActiveRepository) {
        this.cryptoCurrencyRepository = cryptoCurrencyRepository;
        this.ticker = ticker;
        this.userActiveRepository = userActiveRepository;
    }

    /**
     * Scheduling inserting cryptos data into database
     */
    @Scheduled(fixedRate = 60000) // every minute
    public void saveCryptoCurrency() {
        Stream.of(ticker.getCrypto()).forEach(crypto -> {
            cryptoCurrencyRepository.save(crypto);
            log.info("saved crypto: {}", crypto);
            checkCryptoPrice(crypto);
        });
    }

    /**
     * getting last crypto data from database
     * @param symbol of crypto
     * @return Cryptocurrency
     */
    public Optional<CryptoCurrency> getActualCrypto(String symbol) {
        return cryptoCurrencyRepository.findActualCrypto(symbol);
    }

    /**
     * compare the value price of crypto in database with the price recorded during registration
     * @param cryptoCurrency saved crypto
     */
    private void checkCryptoPrice(CryptoCurrency cryptoCurrency) {
        log.info("CryptoCurrencyListener checking price");
        String symbol = cryptoCurrency.getSymbol();
        List<UserActive> userActiveList = userActiveRepository.findAllBySymbol(symbol)
                .orElse(Collections.emptyList());
        if (!userActiveList.isEmpty()) {
            UserActive firstActiveUser = userActiveList.get(0);
            if (firstActiveUser != null) {
                double newPrice = cryptoCurrency.getPrice_usd();
                double basePrice = firstActiveUser.getOldPriceUsd();
                if (Math.abs(newPrice - basePrice) / basePrice > 0.01) {
                    log.warn("Price change for symbol {} is more than 1%", cryptoCurrency.getSymbol());
                }
                if (newPrice != basePrice) {
                    log.info("Price {} had change on {}", symbol, newPrice - basePrice);
                }
            } else {
                log.warn("ACTIVE USER NOT EXIST");
            }
        }
    }
}
