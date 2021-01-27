package rc.bootsecurity.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.bootsecurity.model.Card;
import rc.bootsecurity.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private CardRepository cardRepository;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder, CardRepository cardRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        this.userRepository.deleteAll();
        this.cardRepository.deleteAll();

        User dan = new User("dan",passwordEncoder.encode("dan123"),"USER","");
        User bart = new User("bart",passwordEncoder.encode("bart123"),"USER","");
        User tom = new User("tom",passwordEncoder.encode("tom123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        Card card1 = new Card("Bart Bart", "1234567890121234", "12/20", "123");
        Card card2 = new Card("Adam Adam", "3214567890121234", "12/22", "321");


        this.cardRepository.save(card1);
        this.cardRepository.save(card2);
        this.userRepository.save(bart);


        card1.setUser(bart);
        card2.setUser(bart);
        bart.getCards().add(card1);
        bart.getCards().add(card2);

        this.userRepository.save(bart);

        List<User> users = Arrays.asList(dan,tom,admin,manager);

        this.userRepository.saveAll(users);
    }
}
