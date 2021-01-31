package com.bootsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootsecurity.db.CardRepository;
import com.bootsecurity.model.Card;

import java.util.List;
import java.util.Optional;

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
    public Card getCardById(Long id) {
        Optional<Card> optional = cardRepository.findById(id);
        Card employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Card not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteCardById(long id) {
        this.cardRepository.deleteById(id);
    }
}
