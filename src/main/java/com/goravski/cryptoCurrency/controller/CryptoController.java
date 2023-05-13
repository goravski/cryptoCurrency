package com.goravski.cryptoCurrency.controller;

import com.goravski.cryptoCurrency.model.CryptoName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CryptoController {

    @GetMapping("/")
    public String viewStart() {
        return "Start view here!";
    }

    @GetMapping("crypto")
    public List<CryptoName> viewList() {
        return List.of(CryptoName.values());
    }

    @GetMapping("/{cryptoId}")
    public BigDecimal viewCurrency(@PathVariable Long cryptoId) {
        return null;
    }
}
