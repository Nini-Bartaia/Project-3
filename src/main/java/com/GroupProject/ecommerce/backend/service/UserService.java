package com.GroupProject.ecommerce.backend.service;

import com.GroupProject.ecommerce.backend.modelBody.LoginBody;
import com.GroupProject.ecommerce.backend.model.User;
import com.GroupProject.ecommerce.backend.modelBody.RegisterBody;
import com.GroupProject.ecommerce.backend.modelBody.UserType;
import com.GroupProject.ecommerce.backend.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {


  //  public static final List<User> users = new ArrayList<>();

    private final UserRepo userRepo;
    private RegisterBody registerBody;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.registerBody = new RegisterBody();
    }


//
//    public UserService(UserRepo userRepo, RegisterBody registerBody) {
//        this.userRepo = userRepo;
//        this.registerBody = registerBody;
//    }
//
//
//    public UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    public static UserType type;
    public User loginedUser;

    String password;
    public User registerUser(RegisterBody registerBody){

        User user= new User();

        user.setUsername(registerBody.getUsername());
       // user.setType(registerBody.getType());
        //user.setPassword(registerBody.getPassword());
        user.setName(registerBody.getName());
        user.setSurname(registerBody.getSurname());
        user.setBirthDate(registerBody.getDateTime());
        user.setBudget(registerBody.getBudget());


        password=registerBody.getPassword();
        type=registerBody.getType();

      //  user.setBudget(registerBody.getBudget());

        return userRepo.save(user);
      //  users.add(user);
     //   return user;


    }


    public User login(LoginBody loginBody) {

        for (User user : userRepo.findAll()) {
            if (user.getUsername().equals(loginBody.getUsername()) && password.equals(loginBody.getPassword())) {
                // Return the user if username and password match
//                type=registerBody.getType();
                loginedUser=user;
                return user;
            }
        }

        // Return null if no matching user found
        return null;
    }

    public List<User> getUsers(){


        return userRepo.findAll();
      //  return users;

    }

    public boolean getType(){

        if(Objects.equals(type.toString(), "ADMIN")){

            return true;
        }else{
            return false;
        }
    }


    public static String getUserRole(UserType type) {
        if (type == UserType.ADMIN) {
            return "ROLE_ADMIN";
        } else {
            return "ROLE_USER";
        }
    }

    public User getUser(){

        return this.loginedUser;
    }

}

