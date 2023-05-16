package com.goravski.cryptoCurrency.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class UserActive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registeredId;

    @Column
    private double oldPriceUsd;

    @ManyToOne (fetch = FetchType.LAZY)
    private Users users;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "symbol")
    private List<CryptoCurrency> cryptoCurrency;

}
