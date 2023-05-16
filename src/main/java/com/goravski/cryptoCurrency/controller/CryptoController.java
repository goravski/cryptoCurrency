package com.goravski.cryptoCurrency.controller;

import com.goravski.cryptoCurrency.model.CryptoCurrency;
import com.goravski.cryptoCurrency.model.CryptoName;
import com.goravski.cryptoCurrency.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Getting data obout crypto from database
 */
@RestController
public class CryptoController {

    private final CryptoCurrencyService cryptoCurrencyService;

    @Autowired
    public CryptoController(CryptoCurrencyService cryptoCurrencyService) {
        this.cryptoCurrencyService = cryptoCurrencyService;
    }

    /**
     *
     * @return list of available crypto
     */
    @GetMapping("main")
    public List<CryptoName> viewList() {
        return List.of(CryptoName.values());
    }

    /**
     *
     * @param symbol crypto
     * @return actual data crypto from database
     */
    @GetMapping("main/{symbol}")
    public ResponseEntity<CryptoCurrency> getActualCrypto(@PathVariable String symbol) {
        Optional<CryptoCurrency> optionalCryptoCurrency = cryptoCurrencyService.getActualCrypto(symbol);
        return optionalCryptoCurrency.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
