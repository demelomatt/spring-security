package com.matheus.melo.springsecurity6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/balances")
    public String getBalanceDetails() {
        return "Here are the balance details from the DB";
    }
}
