package pl.kamilfurdal.demorepo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kamilfurdal.demorepo.models.repositories.ReservationRepository;

@Controller
public class RestController {


    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping(value = "/rest/reservation", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity reservation(){
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }
    
}
