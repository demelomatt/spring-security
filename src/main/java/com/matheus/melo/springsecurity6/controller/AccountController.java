package com.matheus.melo.springsecurity6.controller;

import com.matheus.melo.springsecurity6.model.Account;
import com.matheus.melo.springsecurity6.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/accounts")
    public Account getAccountDetails(@RequestParam int id) {
        return accountsRepository.findByCustomerId(id);
    }

}
