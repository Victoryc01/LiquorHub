package com.blaze.liquorhub.model;

import jakarta.persistence.*;
import lombok.*;
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity

    @Table(name = "admin")

    public class Admin {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;



}
