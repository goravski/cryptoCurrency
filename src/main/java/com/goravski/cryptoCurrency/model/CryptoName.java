package com.goravski.cryptoCurrency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Set crypto id & symbol
 */
@Getter
@AllArgsConstructor
public enum CryptoName {
    BTC(90),
    ETH(80),
    SOL(48543);

    private int CryptoId;


}
