package com.goravski.cryptoCurrency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Set crypto id & symbol
 */
@Getter
@AllArgsConstructor
public enum CryptoName {
    BTC(90, "BTC"),
    ETH(80, "ETH"),
    SOL(48543, "SOL");

    private int CryptoId;
    private String symbol;
}
