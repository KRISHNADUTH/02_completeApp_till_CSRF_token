package com.SpringBootFinalApp.completeApp.service;

import java.sql.Date;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBootFinalApp.completeApp.model.Contact;
import com.SpringBootFinalApp.completeApp.repository.ContactRepository;

@Service
public class ContactService {

    ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ResponseEntity<Contact> saveContact(Contact contact) {
        contact.setContactId(getServiceReqNum());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        contactRepository.save(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    private String getServiceReqNum() {
        Random random = new Random();
        return "SR" + (random.nextInt(999999999 - 9999) + 9999);
    }

}
