package com.bootsecurity.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bootsecurity.model.Card;
import com.bootsecurity.model.User;

@Service
public class DbInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CardRepository cardRepository;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder, CardRepository cardRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) {
        this.userRepository.deleteAll();
        this.cardRepository.deleteAll();

        User bart = new User("bart",passwordEncoder.encode("bart123"),"USER","");
        User tom = new User("tom",passwordEncoder.encode("tom123"),"USER","");

        Card card1 = new Card("Karta1", "1234567890121234", "12/20", "123");
        Card card2 = new Card("Karta2", "3214567890121234", "12/22", "321");


        this.cardRepository.save(card1);
        this.cardRepository.save(card2);
        this.userRepository.save(bart);


        card1.setUser(bart);
        card2.setUser(bart);
        bart.getCards().add(card1);
        bart.getCards().add(card2);

        this.userRepository.save(bart);
        this.userRepository.save(tom);
    }
}
