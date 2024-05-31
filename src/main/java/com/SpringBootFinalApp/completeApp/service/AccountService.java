package com.SpringBootFinalApp.completeApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBootFinalApp.completeApp.model.Account;
import com.SpringBootFinalApp.completeApp.repository.AccountRepoSitory;

@Service
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    AccountRepoSitory accountRepoSitory;

    public AccountService(AccountRepoSitory accountRepoSitory) {
        this.accountRepoSitory = accountRepoSitory;
    }

    public ResponseEntity<Account> getAccountDetails(Long id) {
        try { 
            Account accountDetail = accountRepoSitory.findByCustomerId(id);
            if (null != accountDetail) {
                return new ResponseEntity<Account>(accountDetail , HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("An error occurred while retrieving account details", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}