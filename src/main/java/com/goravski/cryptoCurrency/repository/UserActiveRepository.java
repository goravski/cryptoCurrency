package com.goravski.cryptoCurrency.repository;


import com.goravski.cryptoCurrency.model.UserActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserActiveRepository extends JpaRepository <UserActive, Long> {


   Optional <List<UserActive>> findAllBySymbol(String symbol);
}
