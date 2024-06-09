package com.SpringBootFinalApp.completeApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalApp.completeApp.model.Customer;
import com.SpringBootFinalApp.completeApp.service.CustomerService;

@RestController
public class CutomerController {

    CustomerService customerService;

    public CutomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomer(@RequestParam Integer id)
    {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
    {
        System.out.println("Recieved customer : " + customer.toString());
        System.out.println("Authorities : " + customer.getAuthorities());
        return customerService.addCustomer(customer);
    }
}
