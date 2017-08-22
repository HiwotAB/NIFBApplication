package hiwotab.nifb.controller;

import hiwotab.nifb.Model.FBPlay;
import hiwotab.nifb.repositories.FBPlayRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    FBPlayRepostory fbPlayRepostory;

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }
    // TO show the the form that is used to enter tv shows
    @GetMapping("/fbForm")
    public String fbPlayForm(Model model) {
        model.addAttribute("newfbPlay", new FBPlay());
        return "fbForm";
    }

    // TO submit the list of attribute values to the data base
    @PostMapping("/fbForm")
    public String fbPlayForm(@Valid @ModelAttribute("newfbPlay") FBPlay fbPlay, Model model,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "fbForm";
        }
        fbPlayRepostory.save(fbPlay);
        ArrayList<String> fBResults = fbPlay.runFizzBuzz();
        for(String item:fBResults)
        {
            System.out.println(item);
        }
        model.addAttribute("fBR",fBResults);
        return "confirmfbForm";
    }

    @GetMapping("/displayFBPlay")
    public String disFBPlayForm(Model model) {
        model.addAttribute("searchPay",fbPlayRepostory.findAll());
        return "displayFBPlay";

    }

}
