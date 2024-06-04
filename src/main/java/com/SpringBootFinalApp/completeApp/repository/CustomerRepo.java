package com.SpringBootFinalApp.completeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootFinalApp.completeApp.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    
    List<Customer> findByEmail(String email);
}
