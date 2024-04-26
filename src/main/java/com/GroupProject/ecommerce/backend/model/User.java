package com.GroupProject.ecommerce.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.GroupProject.ecommerce.backend.modelBody.UserType;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String birthDate;
    private double budget;

//    private String password;
//    @NotNull

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
//
//    private UserType type; // can be either "admin" or "user"
//
//    private double budget=1000;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public UserType getType() {
//        return type;
//    }
//
//    public void setType( UserType type) {
//        this.type = type;
//    }
////
//    public double getBudget() {
//        return budget;
//    }
//
//    public void setBudget(double budget) {
//        this.budget = budget;
//    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//



}
