package com.capgemini.node.service;

import com.capgemini.node.exception.CardNotFoundException;
import com.capgemini.node.model.Card;
import com.capgemini.node.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CardServiceImpl implements CardService{

    public CardServiceImpl() {

    }
    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }


    @Override
    public Card addCard(Card card) {
        cardRepository.save(card);
        return card;
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(Integer card_id) {
        Optional<Card> optionalCard=cardRepository.findById(card_id);
        if(optionalCard.isEmpty())
            throw new CardNotFoundException("Invalid Card ID entered or does not exist");
        return optionalCard.get();
    }

    @Override
    public Card getCardByName(String cardName) {
        Optional<Card> optionalCard=cardRepository.findBycardName(cardName);
        if(optionalCard.isEmpty())
            throw new CardNotFoundException("Incorrect Card Name or does not exist");
        return optionalCard.get();
    }

    @Override
    public void deleteCard(Integer card_id) {
        Optional<Card> optionalCard=cardRepository.findById(card_id);
        if(optionalCard.isEmpty())
            throw new CardNotFoundException("Card ID entered does not exist");
        cardRepository.deleteById(card_id);
    }

    @Override
    public Card updateCard(Integer card_id, Card card) {
        Optional<Card> optionalCard=cardRepository.findById(card_id);
        if(optionalCard.isEmpty())
            throw new CardNotFoundException("Card ID entered does not exist");
        optionalCard.get().setCardName(card.getCardName());
        optionalCard.get().setCard_type(card.getCard_type());
        return optionalCard.get();
    }
}
