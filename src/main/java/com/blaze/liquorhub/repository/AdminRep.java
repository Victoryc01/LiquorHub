package com.blaze.liquorhub.repository;

import com.blaze.liquorhub.model.Admin;
import com.blaze.liquorhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRep extends JpaRepository <Admin, Long>{
    Optional<Admin> findByNameAndPassword(String name, String password);
    Optional<Admin>findFirstByName(String name);
}
