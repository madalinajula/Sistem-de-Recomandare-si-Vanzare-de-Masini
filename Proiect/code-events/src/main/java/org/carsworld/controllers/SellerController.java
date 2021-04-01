package org.carsworld.controllers;

import org.aspectj.lang.annotation.Around;
import org.carsworld.data.CarRepository;
import org.carsworld.data.SellerRepository;
import org.carsworld.models.Car;
import org.carsworld.models.Seller;
import org.carsworld.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seller")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;

    @Around("register")
    @GetMapping("register")
    public String displayRegisterSellerForm(Model model){
        model.addAttribute("title","Register seller");
        return "seller/register";
    }

    @Around("register")
    @PostMapping("register")
    public String processRegisterSellerForm(@ModelAttribute Seller seller){

            if(seller.getUsername().equals("seller") && seller.getPassword().equals("seller")) {
                return "seller/choose";
            }

        return "seller/register";
    }


}
