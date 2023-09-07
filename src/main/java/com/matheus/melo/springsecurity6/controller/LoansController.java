package com.matheus.melo.springsecurity6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/loans")
    public String getLoanDetails() {
        return "Here are the loan details from the DB";
    }
}