package com.blaze.liquorhub.service;

import com.blaze.liquorhub.model.Product;
import com.blaze.liquorhub.model.User;
import com.blaze.liquorhub.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRep userRep;

    @Autowired
    public UserService(UserRep userRep) {
        this.userRep = userRep;
    }

    public User createUser(String name, String email, String password){

        if (name == null || password==null){
            return null;
        }else {
            if (userRep.findFirstByName(name).isPresent()){
                System.out.println("User Already Onboard");
                return null;
            }
            User user = new User();

            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            userRep.save(user);

            return user;
        }

    }

    public User authentication(String name, String password){
        return userRep.findByNameAndPassword(name, password).orElse(null);

    }

    public List<User> getAllUser(){
        return userRep.findAll();
    }



}
