package saron.springframework.petclinic.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import saron.springframework.petclinic.services.VetService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    @RequestMapping({"", "/", "/index", "/index.html", ".html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
