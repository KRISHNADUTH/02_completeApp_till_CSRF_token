package com.SpringBootFinalApp.completeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootFinalApp.completeApp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    boolean existsByEmail(String string);

}
