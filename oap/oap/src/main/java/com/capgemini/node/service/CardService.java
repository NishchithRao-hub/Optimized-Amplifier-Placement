package com.capgemini.node.service;

import com.capgemini.node.model.Card;
import java.util.List;

public interface CardService {

    public Card addCard(Card card);
    public List<Card> getAllCards();
    public Card getCardById(Integer card_id);
    public Card getCardByName(String cardName);
    public void deleteCard(Integer card_id);
    public Card updateCard(Integer card_id, Card card);
}
