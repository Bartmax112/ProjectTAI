package com.bootsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootsecurity.db.CardRepository;
import com.bootsecurity.model.Card;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public void saveCard(Card card) {
        this.cardRepository.save(card);
    }

    @Override
    public void deleteCardById(long id) {
        this.cardRepository.deleteById(id);
    }
}
