package com.SpringBootFinalApp.completeApp.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBootFinalApp.completeApp.model.Authority;
import com.SpringBootFinalApp.completeApp.model.Customer;
import com.SpringBootFinalApp.completeApp.repository.CustomerRepository;

@Service
public class CustomerService {

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    CustomerRepository customerRepository;

    public ResponseEntity<Customer> addCustomer(Customer customer) {
        if (customerRepository.existsByEmail(customer.getEmail())) {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        } else {
            System.out.println("Submitted authorities -> "+customer.getAuthorities());
            for (Authority authority : customer.getAuthorities())
            {
                authority.setCustomer(customer);
            }
            return new ResponseEntity<Customer>(customerRepository.save(customer), HttpStatus.OK);
        }
        
    }

    public ResponseEntity<Customer> getCustomer(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<Customer>(customer.get(), HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
