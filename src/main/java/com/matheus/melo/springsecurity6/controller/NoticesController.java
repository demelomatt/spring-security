package com.matheus.melo.springsecurity6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String saveContactDetails() {
        return "Here are the notices details from the DB";
    }
}
