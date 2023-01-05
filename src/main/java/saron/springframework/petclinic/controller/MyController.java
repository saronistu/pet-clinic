package saron.springframework.petclinic.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello() {
        return "Hello";
    }

}
