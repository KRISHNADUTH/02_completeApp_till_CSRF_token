package com.SpringBootFinalApp.completeApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalApp.completeApp.model.Contact;
import com.SpringBootFinalApp.completeApp.service.ContactService;

@RestController
public class ContactController {

    ContactService contactService;
    
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> saveContactEnquiryDetails(@RequestBody Contact contact)
    {
        return contactService.saveContact(contact);
    }
}
