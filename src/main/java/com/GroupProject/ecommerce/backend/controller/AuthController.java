package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.User;
import com.GroupProject.ecommerce.backend.modelBody.*;
import com.GroupProject.ecommerce.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController

public class AuthController {

    private final UserService userService;

    private static final ThreadLocal<User> userHolder = new ThreadLocal<>();


    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterBody registerBody){

        User newUser = userService.registerUser(registerBody);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginBody loginBody) {
        User user = userService.login(loginBody);

        //return  new LoginResponse(user, userService.getType());
        return  new LoginResponse(user, userService.getType());
    }



}
