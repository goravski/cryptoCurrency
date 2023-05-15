package com.goravski.cryptoCurrency.utils;

import com.goravski.cryptoCurrency.model.CryptoCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Make connection with resource and get JSON objects (crypto currency)
 */
@Component
public class CryptoSchedulerTicker {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL_TICKER = "https://api.coinlore.net/api/ticker/?id=";


    public CryptoCurrency[] getCrypto() {
        String url = URL_TICKER + Util.getCryptoId();
        return restTemplate.getForEntity(url, CryptoCurrency[].class).getBody();

    }

}
