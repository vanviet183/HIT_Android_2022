package com.vitvn183.buoi4;

public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
