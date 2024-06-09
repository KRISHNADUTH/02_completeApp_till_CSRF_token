package com.SpringBootFinalApp.completeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootFinalApp.completeApp.model.Authority;

public interface AuthorityRepo extends JpaRepository<Authority, Integer> {

    List<Authority> findByCustomerId(int id);
    
}
