package com.goravski.cryptoCurrency.controller;

import com.goravski.cryptoCurrency.model.Users;
import com.goravski.cryptoCurrency.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @return List Users from userService
     */
    @GetMapping("/users")
    public List <Users> getUserByLogin(){
        return  userService.getAllUsers();
    }

    /**
     *
     * @param login User
     * @return User by Login from userService
     */
    @GetMapping("/user/{login}")
    public Optional<Users> getUserByLogin(@PathVariable String login){
        return  userService.getUserByLogin(login);
    }

    /**
     *
     * @param user login and e-mail in JSON format in body request
     * @return save User to userService
     */
    @PostMapping("/login")
    public ResponseEntity<?> createUser(@RequestBody Users user) {
        Users savedUser = userService.save(user).orElseThrow(() -> new RuntimeException("User not found"));
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
