package com.GroupProject.ecommerce.backend.modelBody;

import com.GroupProject.ecommerce.backend.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;


public class RegisterResponse {

    private String name;
    private String surname;

    private String username;

    private Date dateTime;

//    private User user;
//
//    public RegisterResponse(User user) {
//        this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
