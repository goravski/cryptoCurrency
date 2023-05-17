package com.goravski.cryptoCurrency.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
public class UserActive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registeredId;

    @Column
    private double oldPriceUsd;

    @ManyToOne (fetch = FetchType.EAGER)
    private Users users;

    @Column
    private String symbol;

}
