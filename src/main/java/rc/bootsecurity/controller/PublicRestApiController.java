package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.bootsecurity.db.CardRepository;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.Card;
import rc.bootsecurity.model.User;
import rc.bootsecurity.services.CardService;

import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    private UserRepository userRepository;
    private CardRepository cardRepository;


    public PublicRestApiController(UserRepository userRepository, CardRepository cardRepository){
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("users")
    public List<User> users(){
        return this.userRepository.findAll();
    }



}
