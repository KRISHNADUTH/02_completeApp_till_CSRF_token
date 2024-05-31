package com.SpringBootFinalApp.completeApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalApp.completeApp.model.AccountTransactions;
import com.SpringBootFinalApp.completeApp.service.AccountTransactionService;

@RestController
public class AccountTransactionController {
    
    AccountTransactionService accountTransactionService;
    
    public AccountTransactionController(AccountTransactionService balanceService) {
        this.accountTransactionService = balanceService;
    }

    @GetMapping("/myBalance")
    public ResponseEntity<List<AccountTransactions>> getAccountTransactionsByCustomerId(@RequestParam Integer id) {
        return accountTransactionService.getAccountTransactionsByCustomerId(id);
    }
}
