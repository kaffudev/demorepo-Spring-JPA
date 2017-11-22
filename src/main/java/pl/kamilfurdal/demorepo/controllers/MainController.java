package pl.kamilfurdal.demorepo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kamilfurdal.demorepo.models.services.StringService;

@Controller
public class MainController {

    @Autowired
    StringService stringService;

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "Cześć co słychać" + stringService.generateRandomString();
    }

}
