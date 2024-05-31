package com.SpringBootFinalApp.completeApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalApp.completeApp.model.Account;
import com.SpringBootFinalApp.completeApp.service.AccountService;

@RestController
public class AccountController {

    AccountService accountService;

    

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/myAccount")
    public ResponseEntity<Account> getAccountDetails(@RequestParam long id) {
        return accountService.getAccountDetails(id);
    }
}
