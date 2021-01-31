package com.bootsecurity.services;

import com.bootsecurity.model.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();
    void saveCard(Card card);

    void deleteCardById(long id);

}
