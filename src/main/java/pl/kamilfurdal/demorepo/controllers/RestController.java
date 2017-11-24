package pl.kamilfurdal.demorepo.controllers;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.kamilfurdal.demorepo.models.ReservationModel;
import pl.kamilfurdal.demorepo.models.repositories.ReservationRepository;

@Controller
public class RestController {


    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping(value = "/api/reservation", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity reservation(){
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/reservation/{lastname}", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity reservation(@PathVariable("lastname") String lastname){
        return new ResponseEntity(reservationRepository.findByLastname(lastname),HttpStatus.OK);
    }

    @RequestMapping(value = "/api/reservation", method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity reservation(@RequestBody ReservationModel model){
        reservationRepository.save(model);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/reservation/{id}", method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity reservation(@PathVariable("id") int id){
        reservationRepository.delete(Long.valueOf(id));
        return new ResponseEntity(HttpStatus.OK);
    }


}
