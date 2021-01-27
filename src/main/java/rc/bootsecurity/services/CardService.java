package rc.bootsecurity.services;

import rc.bootsecurity.model.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();
    void saveCard(Card card);
    Card getCardById(Long id);
    void deleteCardById(long id);

}
