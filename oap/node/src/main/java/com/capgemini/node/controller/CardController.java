package com.capgemini.node.controller;

import com.capgemini.node.model.Card;
import com.capgemini.node.repository.CardRepository;
import com.capgemini.node.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/card")
public class CardController {

    private CardService cardService;

    private CardRepository cardRepository;

    @Autowired
    public CardController(CardService cardService, CardRepository cardRepository) {
        this.cardService = cardService;
        this.cardRepository = cardRepository;
    }

    @GetMapping(path="/get-cards")
    public ResponseEntity<List<Card>> getAllCards(){
        return new  ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
    }
    @GetMapping(path="/get-cards-by-id/{card_id}")
    public Card getCardById(@PathVariable Integer card_id){
        return cardService.getCardById(card_id);
    }
    @GetMapping(path="/get-cards-by-name/{cardName}")
    public Card getCardByName(@PathVariable String cardName){
        return cardService.getCardByName(cardName);
    }

    @PostMapping(path="/add-card")
    public Card addCard(@RequestBody Card card){
        return cardService.addCard(card);
    }

    @PutMapping(path="/update-card")
    public Card updateCard(@RequestParam Integer card_id,
                           @RequestBody Card card){
        return cardService.updateCard(card_id,card);
    }

    @DeleteMapping(path="/delete-card")
    public void deleteCard(@RequestParam Integer card_id){
        cardService.deleteCard(card_id);
    }
}
