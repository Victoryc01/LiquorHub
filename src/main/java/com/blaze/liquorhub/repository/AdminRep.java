package com.blaze.liquorhub.repository;

import com.blaze.liquorhub.model.Admin;
import com.blaze.liquorhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRep extends JpaRepository <Admin, Integer>{
    Optional<User>findByNameAndPassword(String name, String password);
    Optional<User>findFirstByName(String name);
}
