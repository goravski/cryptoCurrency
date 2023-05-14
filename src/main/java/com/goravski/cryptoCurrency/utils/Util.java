package com.goravski.cryptoCurrency.utils;

import com.goravski.cryptoCurrency.model.CryptoName;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

    /**
     * @return transform value of available crypto
     */
    public static String getCryptoId (){
        return  Stream.of(CryptoName.values())
                .map(CryptoName::getCryptoId)
                .map(Objects::toString)
                .collect(Collectors.joining(","));

    }
}
