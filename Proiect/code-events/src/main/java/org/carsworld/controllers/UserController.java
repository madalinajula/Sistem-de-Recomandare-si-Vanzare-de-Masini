package org.carsworld.controllers;


import org.carsworld.data.UserRepository;
import org.carsworld.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("index")
    public String displayAllEvents(Model model) {
        model.addAttribute("title","All users");
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }

    @GetMapping("create")
    public String displayCreateUserForm(Model model){
        model.addAttribute("title","Create user");
        return "users/create";
    }

    @PostMapping("create")
    public String processCreateUserForm(@ModelAttribute User newUser){
        userRepository.save(newUser);
        return "users/create";
    }


    @GetMapping("register")
    public String displayRegisterUserForm(Model model){
        model.addAttribute("title","Register user");
        return "users/register";
    }

    @PostMapping("register")
    public String processRegisterUserForm(@ModelAttribute User user){
        for (User user1:userRepository.findAll()) {
            if(user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword())){
                return "users/choose";
            }
        }
        return "users/register";
    }

    @GetMapping("delete")
    public String displayDeleteUserForm(Model model){
        model.addAttribute("title","Delete User");
        model.addAttribute("users",userRepository.findAll());
        return "users/delete";
    }

    @PostMapping("delete")
    public String processDeleteUserForm(@RequestParam(required = false) int[] userIds )
    {    if (userIds != null) {
        for (int id : userIds) {
            userRepository.deleteById(id);

        }
    }
        return "users/delete";

    }
}
