package com.blaze.liquorhub.controller;

import com.blaze.liquorhub.model.Admin;
//import com.blaze.liquorhub.model.User;
import com.blaze.liquorhub.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String getAdminReg(Model model){
        model.addAttribute("adminRegisterRequest", new Admin());
        return "admin_logs";
    }

    @PostMapping("/admin")
    public String adminReg(@ModelAttribute Admin admin){
        System.out.println("ADMIN REG REQUEST" + admin);

        Admin registarAdmin = adminService.createAdmin(admin.getName(), admin.getEmail(), admin.getPassword());

        return registarAdmin ==null ? "error_page" : "redirect:/adminLog";
    }

    @GetMapping("/adminLog")
    public String getAdminLogin(Model model){
        model.addAttribute("adminLoginRequest", new Admin());
        return "admin_logs";
    }

    @PostMapping("/adminLog")
    public String adminLog(@ModelAttribute Admin admin, Model model){
        System.out.println("Admin login request" + admin);
        Admin authh = adminService.authentications(admin.getName(),admin.getPassword());
        if (authh != null){
//            return "redirect:/";
            return "admin_dash";
        }else {
            return  "error_page";

        }
    }

}
