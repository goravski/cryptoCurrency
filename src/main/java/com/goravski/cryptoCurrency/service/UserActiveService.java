package com.goravski.cryptoCurrency.service;

import com.goravski.cryptoCurrency.model.UserActive;
import com.goravski.cryptoCurrency.repository.UserActiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserActiveService {
    private final UserActiveRepository userActiveRepository;


    @Autowired
    public UserActiveService(UserActiveRepository userActiveRepository) {
        this.userActiveRepository = userActiveRepository;
    }

    public UserActive registerUser(UserActive userActive) {
        return userActiveRepository.save(userActive);
    }
}
