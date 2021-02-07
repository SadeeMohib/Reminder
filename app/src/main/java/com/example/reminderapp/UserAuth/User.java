package com.example.reminderapp.UserAuth;

public class User {
    public String username, email, age, weight, password, gender;

    public User()
    {

    }
    public User(String username,String email,String age,String weight,String gender,String password)
    {
        this.username=username;
        this.email=email;
        this.age=age;
        this.weight=weight;
        this.gender=gender;
        this.password=password;
    }
}
