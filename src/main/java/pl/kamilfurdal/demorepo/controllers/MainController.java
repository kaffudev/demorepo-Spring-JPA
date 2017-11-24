package pl.kamilfurdal.demorepo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kamilfurdal.demorepo.models.ReservationModel;
import pl.kamilfurdal.demorepo.models.forms.ReservationForm;
import pl.kamilfurdal.demorepo.models.repositories.ReservationRepository;
import pl.kamilfurdal.demorepo.models.services.StringService;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {


    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("reservationForm",new ReservationForm());
        model.addAttribute("reservations", reservationRepository
                .findByDateIsBetween(LocalDate.now(),LocalDate.now().plusWeeks(1)));
        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form, BindingResult result, Model model){
            if (result.hasErrors()) {
                return "index";
            }
            else if (reservationRepository.existsByDateEquals(form.getFormatedDate())){
                model.addAttribute("error", "Ten dzień jest już zajęty");
        }

        reservationRepository.save(new ReservationModel(form));

        return "index";
    }

    /*@GetMapping("/test")
    @ResponseBody
    public String index(){
        List<ReservationModel> reservationModel = reservationRepository.findByName("Kamil");


        return reservationModel.stream()
                .map(s -> s.toString())
                .collect(Collectors.joining( " , "));
    }
*/
}
