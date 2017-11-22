package pl.kamilfurdal.demorepo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kamilfurdal.demorepo.models.ReservationModel;
import pl.kamilfurdal.demorepo.models.forms.ReservationForm;
import pl.kamilfurdal.demorepo.models.repositories.ReservationRepository;
import pl.kamilfurdal.demorepo.models.services.StringService;

import java.sql.Date;
import java.util.Calendar;

@Controller
public class MainController {

    @Autowired
    StringService stringService;

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("reservationForm",new ReservationForm());

        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") ReservationForm form){
        reservationRepository.save(new ReservationModel(form));

        return "index";
    }

}
