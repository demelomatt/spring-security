package com.matheus.melo.springsecurity6.controller;

import com.matheus.melo.springsecurity6.model.Customer;
import com.matheus.melo.springsecurity6.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
        var registered =  userService.registerCustomer(customer);
        return ResponseEntity.ok(registered);
    }
}
