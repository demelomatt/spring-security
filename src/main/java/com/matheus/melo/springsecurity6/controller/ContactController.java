package com.matheus.melo.springsecurity6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/contacts")
    public String saveContactDetails() {
        return "Inquiry details are saved to the DB";
    }
}
