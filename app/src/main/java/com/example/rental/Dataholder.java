package com.example.rental;

public class Dataholder {

    String name,email,userId,password;

    public Dataholder(String Name, String Email, String UserId, String Password) {
        name =  Name;
        email = Email;
        userId = UserId;
        password = Password;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
       email = Email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String UserId) {
        userId = UserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        password = Password;
    }
}


