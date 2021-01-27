package rc.bootsecurity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rc.bootsecurity.db.CardRepository;
import rc.bootsecurity.model.Card;
import rc.bootsecurity.services.CardService;

import java.util.List;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;



}
