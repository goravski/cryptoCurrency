package com.goravski.cryptoCurrency.controller;


import com.goravski.cryptoCurrency.model.CryptoCurrency;
import com.goravski.cryptoCurrency.model.UserActive;
import com.goravski.cryptoCurrency.model.Users;
import com.goravski.cryptoCurrency.service.CryptoCurrencyService;
import com.goravski.cryptoCurrency.service.UserActiveService;
import com.goravski.cryptoCurrency.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Log4j2
public class UserActiveController {
    private final UserActiveService userActiveService;
    private final CryptoCurrencyService cryptoCurrencyService;
    private final UserService userService;

    @Autowired
    public UserActiveController(UserActiveService userActiveService, CryptoCurrencyService cryptoCurrencyService, UserService userService) {
        this.userActiveService = userActiveService;
        this.cryptoCurrencyService = cryptoCurrencyService;
        this.userService = userService;
    }


    @PostMapping("/registration/{login}/{symbol}")
    public ResponseEntity<?> registerUser(@PathVariable String login, @PathVariable String symbol) {
        Users user = userService.getUserByLogin(login).orElseThrow(() -> new RuntimeException("User not found"));
        CryptoCurrency crypto = cryptoCurrencyService.getActualCrypto(symbol)
                .orElseThrow(() -> new RuntimeException("Crypto not found"));
        UserActive userActive = new UserActive();
        userActive.setSymbol(symbol);
        userActive.setOldPriceUsd(crypto.getPrice_usd());
        userActive.setUsers(user);
        UserActive registeredUser = userActiveService.registerUser(userActive);
        log.info("REGISTERED USER ACTIVE {}", userActive);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

}
