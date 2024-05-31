package com.SpringBootFinalApp.completeApp.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBootFinalApp.completeApp.model.Loans;
import com.SpringBootFinalApp.completeApp.repository.LoanRepository;

@Service
public class LoanService {

    LoanRepository loansRepository;
    
    public LoanService(LoanRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    public ResponseEntity<List<Loans>> getLoanDetails(int id) {
        return new ResponseEntity<List<Loans>>(loansRepository.findByCustomerIdOrderByStartDtDesc(id),HttpStatus.OK);
    }


}
