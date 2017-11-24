package pl.kamilfurdal.demorepo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kamilfurdal.demorepo.models.ReservationModel;
import pl.kamilfurdal.demorepo.models.forms.ReservationForm;
import pl.kamilfurdal.demorepo.models.repositories.ReservationRepository;


import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class MainController {


    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/{page}")
    public String index(Model model , @PathVariable("page") int pageNumber){
        model.addAttribute("reservationForm",new ReservationForm());
        PageRequest pageRequest = new PageRequest(pageNumber, 2);

        model.addAttribute("reservations", reservationRepository
                .findByDateIsBetween(LocalDate.now(),LocalDate.now().plusWeeks(1), pageRequest));
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

    @GetMapping("/reservation/delete")
    public String deleteReservation(@RequestParam String id){
        reservationRepository.delete(Long.valueOf(id));
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
