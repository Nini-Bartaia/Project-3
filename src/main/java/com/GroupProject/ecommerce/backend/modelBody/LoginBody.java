package com.GroupProject.ecommerce.backend.modelBody;

public class LoginBody {


    private String username;

    private String password;

    private UserType type;

    private int budget=1000;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public UserType getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
