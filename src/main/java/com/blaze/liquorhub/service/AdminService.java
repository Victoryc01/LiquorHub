package com.blaze.liquorhub.service;

import com.blaze.liquorhub.model.Admin;
import com.blaze.liquorhub.model.User;
import com.blaze.liquorhub.repository.AdminRep;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminService {

    private final AdminRep adminRep;

    @Autowired
    public AdminService(AdminRep adminRep){

        this.adminRep = adminRep;
    }
    public Admin createAdmin(String name, String email, String password){

        if (name == null || password==null){
            return null;
        }else {
            if (adminRep.findFirstByName(name).isPresent()){
                System.out.println("User Already Onboard");
                return null;
            }
            Admin admin = new Admin();

            admin.setName(name);
            admin.setEmail(email);
            admin.setPassword(password);

            adminRep.save(admin);

            return null;
        }
    }

    public Admin authenticationz(String name, String password){
        return adminRep.findByNameAndPassword(name, password).orElse(null);
    }
}
