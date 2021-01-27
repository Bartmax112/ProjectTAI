package rc.bootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rc.bootsecurity.db.CardRepository;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.User;

import java.util.List;

@Controller
@RequestMapping("api/public")
public class PublicRestApiController {
    private UserRepository userRepository;
    private CardRepository cardRepository;


    public PublicRestApiController(UserRepository userRepository, CardRepository cardRepository){
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @GetMapping("users")
    public List<User> users(){
        return this.userRepository.findAll();
    }



}
