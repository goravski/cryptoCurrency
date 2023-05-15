package com.goravski.cryptoCurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoCurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoCurrencyApplication.class, args);
	}

}
