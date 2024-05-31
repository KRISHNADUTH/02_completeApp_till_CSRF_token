package com.SpringBootFinalApp.completeApp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBootFinalApp.completeApp.model.AccountTransactions;
import com.SpringBootFinalApp.completeApp.repository.AccountTransactionRepository;

@Service
public class AccountTransactionService {

    private static final Logger logger = LoggerFactory.getLogger(AccountTransactionService.class);
    AccountTransactionRepository accountTransactionRepository;
    
    public AccountTransactionService(AccountTransactionRepository balanceRepository) {
        this.accountTransactionRepository = balanceRepository;
    }

    public ResponseEntity<List<AccountTransactions>> getAccountTransactionsByCustomerId(Integer id) {
        try 
        {
            List<AccountTransactions> accountTransactions = accountTransactionRepository
                    .findByCustomerIdOrderByTransactionDtDesc(id);
            if (!accountTransactions.isEmpty())
            {
                return new ResponseEntity<List<AccountTransactions>>(accountTransactions, HttpStatus.OK);
            }
            else
            {
                logger.error("Cannot find transaction for customer with ID - "+id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error occured while retrieving transaction history", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
