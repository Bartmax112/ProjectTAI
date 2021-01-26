package rc.bootsecurity.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rc.bootsecurity.model.User;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        this.userRepository.deleteAll();

        User dan = new User("dan",passwordEncoder.encode("dan123"),"USER","");
        User bart = new User("bart",passwordEncoder.encode("bart123"),"USER","");
        User tom = new User("tom",passwordEncoder.encode("tom123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(dan,bart,tom,admin,manager);

        this.userRepository.saveAll(users);
    }
}
