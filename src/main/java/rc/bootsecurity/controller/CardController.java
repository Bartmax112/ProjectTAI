package rc.bootsecurity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rc.bootsecurity.db.CardRepository;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.Card;
import rc.bootsecurity.services.CardService;

import java.util.List;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;

    private UserRepository userRepository;

    public CardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/saveCard")
    public String saveCard(@ModelAttribute("card") Card card) {
        // save employee to database
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        card.setUser(userRepository.findByUsername(auth.getName()));
        card.toString();
        cardService.saveCard(card);
        return "redirect:/profile/form";
    }

    @GetMapping("/deleteCard/{id}")
    public String deleteCard(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.cardService.deleteCardById(id);
        return "redirect:/profile/form";
    }


}
