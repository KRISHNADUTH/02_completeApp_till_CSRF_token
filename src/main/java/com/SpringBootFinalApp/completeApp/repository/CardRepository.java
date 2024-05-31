package com.SpringBootFinalApp.completeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootFinalApp.completeApp.model.Cards;

public interface CardRepository extends JpaRepository<Cards,Integer>{

    List<Cards> findByCustomerId(Integer id);

}
