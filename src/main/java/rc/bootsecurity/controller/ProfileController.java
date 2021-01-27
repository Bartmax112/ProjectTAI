package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rc.bootsecurity.model.Card;
import rc.bootsecurity.services.CardService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private CardService cardService;

    @GetMapping("index")
    public String index(){
        return "profile/index";
    }



    @GetMapping("form")
    public String form(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        List<Card> tmp = new ArrayList<>();

        for(Card card : cardService.getAllCards()){
            if(auth.getName()==card.getUser().getUsername()){
                tmp.add(card);
            }
        }

        Card newCard = new Card();

        model.addAttribute("listCards",tmp);
        model.addAttribute("card", newCard);
        return "profile/form";
    }
}
