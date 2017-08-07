package hiwotab.roboresumeapplication.Controller;

import hiwotab.roboresumeapplication.Models.Resume;
import hiwotab.roboresumeapplication.repositories.ResumeRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
// controller class is used as intermidate to our model  to the data base
@Controller
public class MainController {
    DateFormat df=new SimpleDateFormat("MM/dd/YYYY");
    Date date =new Date();

    @Autowired
    ResumeRepostory resumeRepostory;
// TO show the home page of the application
    @GetMapping("/homePage")
    public String showHomePage(Model model) {
        String myMessage = "Welcome to Robo Resume Application";
        model.addAttribute("message", myMessage);
        return "homePage";
    }
    // TO show the the form that is used to enter new user of robo resume application
    @GetMapping("/addUser")
    public String addUserInfo(Model model) {
        model.addAttribute("newUser", new Resume());
        return "addUser";
    }
    // TO submit the list of attribute values to the data base
    @PostMapping("/addUser")
    public String addUserInfo(@Valid @ModelAttribute("newUser") Resume resume, BindingResult bindingResult)throws ParseException {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }

       if(resume.getEndDate()==null){
            resume.setEndDate(df.format(date));
        }
//Calculate the work expirence from the start date difference to end date

        String dateS=resume.getStartDate();
        String dateE=resume.getEndDate();
        Date dateStart=df.parse(dateS);
        Date dateEnd=df.parse(dateE);
        long difference=dateStart.getTime()-dateEnd.getTime();
        long numberOfDays=difference/86400000;
        long diff=Math.abs(numberOfDays);
        resume.setWorkExp(diff);
        resumeRepostory.save(resume);
        return "dispUserInfo";
    }
    // TO show the list of user which has been registered
    @GetMapping("/listAllUsers")
    public String listAllUser(Model model) {
        Iterable<Resume> resumeList = resumeRepostory.findAll();
        model.addAttribute("searchUser", resumeList);
        return "listUser";

    }
    // TO show the work expirence of each user in days
    @GetMapping("/workExp")
    public String calcDateDiff(Model model) throws ParseException {
        Iterable<Resume> resumeList = resumeRepostory.findAll();
        model.addAttribute("searchUser", resumeList);
        return "dipWorkExp";
    }


}