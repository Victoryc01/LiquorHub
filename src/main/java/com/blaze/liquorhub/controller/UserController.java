package com.blaze.liquorhub.controller;

import com.blaze.liquorhub.model.User;
import com.blaze.liquorhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterUserPage(Model model){
        model.addAttribute("registerRequest", new User());
//        return "register_page";
        return "user_form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("register request "+ user);

        User registarUser = userService.createUser(user.getName(), user.getEmail(), user.getPassword());

        return registarUser == null ? "error_page" : "redirect:/login";
    }

    @GetMapping("/login")
    public  String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
//        return "login_page";
        return "user_form";
//        return "admin_dash";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("login request" + user);
        User auth = userService.authentication(user.getName(), user.getPassword());

        if (auth != null){
            return "redirect:/";
        }else {
           return  "error_page";
        }
    }
}
