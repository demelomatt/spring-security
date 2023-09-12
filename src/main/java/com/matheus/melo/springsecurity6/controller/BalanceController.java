package com.matheus.melo.springsecurity6.controller;

import com.matheus.melo.springsecurity6.model.AccountTransaction;
import com.matheus.melo.springsecurity6.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/balances")
    public List<AccountTransaction> getBalanceDetails(@RequestParam int id) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
    }
}
