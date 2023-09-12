package com.matheus.melo.springsecurity6.controller;

import com.matheus.melo.springsecurity6.model.Card;
import com.matheus.melo.springsecurity6.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/cards")
    public List<Card> getCardDetails(@RequestParam int id) {
        return cardsRepository.findByCustomerId(id);
    }

}
