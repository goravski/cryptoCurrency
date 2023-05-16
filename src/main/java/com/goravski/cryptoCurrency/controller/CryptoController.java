package com.goravski.cryptoCurrency.controller;

import com.goravski.cryptoCurrency.model.CryptoCurrency;
import com.goravski.cryptoCurrency.model.CryptoName;
import com.goravski.cryptoCurrency.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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


    @GetMapping("/")
    public String viewStart() {
        return "Start view here!";
    }

    @GetMapping("main")
    public List<CryptoName> viewList() {
        return List.of(CryptoName.values());
    }

    @GetMapping("main/{cryptoId}")
    public ResponseEntity<CryptoCurrency> getCryptoCurrencyByCryptoId(@PathVariable int cryptoId) {
        Optional<CryptoCurrency> optionalCryptoCurrency = cryptoCurrencyService.getCryptoCurrencyByCryptoId(cryptoId);
        return optionalCryptoCurrency.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
