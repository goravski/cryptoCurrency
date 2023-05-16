package com.goravski.cryptoCurrency.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class CryptoCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long currencyId;

    @Column
    private String symbol;

    @Column
    private int id;
    @Column
    private double price_usd;

    @Column(nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @NotNull
    private Date saved = new Date();
}
