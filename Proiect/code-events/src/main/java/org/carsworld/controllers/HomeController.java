package org.carsworld.controllers;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String index(){
        return "index";
    }
}
