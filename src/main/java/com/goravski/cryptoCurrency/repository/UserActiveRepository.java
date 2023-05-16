package com.goravski.cryptoCurrency.repository;


import com.goravski.cryptoCurrency.model.UserActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActiveRepository extends JpaRepository <UserActive, Long> {


}
