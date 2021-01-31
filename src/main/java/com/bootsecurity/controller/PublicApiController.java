package com.bootsecurity.controller;

import com.bootsecurity.db.UserRepository;
import com.bootsecurity.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/public")
public class PublicApiController {
    private final UserRepository userRepository;


    public PublicApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public List<User> users(){
        return this.userRepository.findAll();
    }



}
