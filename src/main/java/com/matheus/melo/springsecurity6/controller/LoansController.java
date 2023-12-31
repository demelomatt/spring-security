package com.matheus.melo.springsecurity6.controller;

import com.matheus.melo.springsecurity6.model.Loan;
import com.matheus.melo.springsecurity6.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/loans")
    public List<Loan> getLoanDetails(@RequestParam int id) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    }

}
