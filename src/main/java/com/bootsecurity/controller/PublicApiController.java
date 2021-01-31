package com.bootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bootsecurity.db.CardRepository;
import com.bootsecurity.db.UserRepository;
import com.bootsecurity.model.User;

import java.util.List;

@Controller
@RequestMapping("api/public")
public class PublicApiController {
    private UserRepository userRepository;
    private CardRepository cardRepository;


    public PublicApiController(UserRepository userRepository, CardRepository cardRepository){
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @GetMapping("users")
    public List<User> users(){
        return this.userRepository.findAll();
    }



}
