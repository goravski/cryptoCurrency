package com.goravski.cryptoCurrency.service;

import com.goravski.cryptoCurrency.model.Users;
import com.goravski.cryptoCurrency.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param login User
     * @return User by Login from database
     */
    public Optional<Users> getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    /**
     * @param user login and e-mail in JSON format in body request
     * @return save User in database
     */
    public Optional<Users> save(Users user) {
        return Optional.of(userRepository.save(user));
    }

    /**
     * @return List Users from database
     */
    public List<Users> getAllUsers() {
        log.debug("Get all users start");
        return userRepository.findAll();
    }
}
