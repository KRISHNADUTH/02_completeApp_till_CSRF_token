package com.SpringBootFinalApp.completeApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalApp.completeApp.model.Loans;
import com.SpringBootFinalApp.completeApp.service.LoanService;

@RestController
public class LoanController {
    LoanService loansService;
    
    public LoanController(LoanService loansService) {
        this.loansService = loansService;
    }

    @GetMapping("/myLoans")
    public ResponseEntity<List<Loans>> getLoanDetailsByCutomerId(@RequestParam int id) {
        return loansService.getLoanDetails(id);
    }
}
