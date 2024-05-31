package com.SpringBootFinalApp.completeApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootFinalApp.completeApp.model.Cards;
import com.SpringBootFinalApp.completeApp.service.CardService;

@RestController
public class CardsController {
    
    CardService cardService;
    
    public CardsController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/myCards")
    public ResponseEntity<List<Cards>> getCardsByCustomerId(@RequestParam Integer id)
    {
        return cardService.getCardsByCustomerId(id);
    }
}
