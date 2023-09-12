package com.matheus.melo.springsecurity6.controller;

import com.matheus.melo.springsecurity6.model.Customer;
import com.matheus.melo.springsecurity6.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
        var registered = customerRepository.save(customer);
        return ResponseEntity.ok(registered);
    }

    @RequestMapping("/users")
    public Customer getUserDetails(Authentication authentication) {
        return customerRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new BadCredentialsException("User details not found for the given user"));
    }
    
}
