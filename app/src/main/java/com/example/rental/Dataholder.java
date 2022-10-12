package com.example.rental;

public class Dataholder { String Name,Email,MobileNO,Password;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNO() {
        return MobileNO;
    }

    public void setMobileNO(String mobileNO) {
        MobileNO = mobileNO;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Dataholder(String name, String email, String mobileNO, String password) {
        Name = name;
        Email = email;
        MobileNO = mobileNO;
        Password = password;

    }
}


