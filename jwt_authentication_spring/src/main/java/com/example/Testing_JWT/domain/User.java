package com.example.Testing_JWT.domain;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int userid;
    private String userName;
    private String password;

    public User() {
    }

    public User( String userName, String password) {

        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

