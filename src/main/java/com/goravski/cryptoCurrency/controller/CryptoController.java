package com.goravski.cryptoCurrency.controller;

import com.goravski.cryptoCurrency.model.Crypto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController("/crypto")
public class CryptoController {

    public List<Crypto> viewList (){
        return null;
    }

    @GetMapping ("/{cryptoId}")
    public BigDecimal viewCurrency (@PathVariable Long cryptoId){
        return null;
    }
}
