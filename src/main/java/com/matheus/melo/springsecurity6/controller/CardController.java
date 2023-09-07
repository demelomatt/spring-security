package com.matheus.melo.springsecurity6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/cards")
    public String getCardDetails() {
        return "Here are the card details from the DB";
    }
}
