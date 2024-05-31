package com.SpringBootFinalApp.completeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootFinalApp.completeApp.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {

}
