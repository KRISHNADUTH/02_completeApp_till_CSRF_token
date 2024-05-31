package com.SpringBootFinalApp.completeApp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBootFinalApp.completeApp.model.Cards;
import com.SpringBootFinalApp.completeApp.repository.CardRepository;

@Service
public class CardService {

    private static Logger logger = LoggerFactory.getLogger(CardService.class);
    CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public ResponseEntity<List<Cards>> getCardsByCustomerId(Integer id) {
        try {
            List<Cards> cardsDetails = cardRepository.findByCustomerId(id);
            if (!cardsDetails.isEmpty()) {
                return new ResponseEntity<List<Cards>>(cardsDetails, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } 
        catch (Exception e) {
            logger.error("Error happened while fetching card details", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
