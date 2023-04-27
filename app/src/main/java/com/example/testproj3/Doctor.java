package com.example.testproj3;

public class Doctor {
    public String fullName,  code, phoneNumber, email, city, address,speciality;

    public Doctor() {
    }

    public Doctor(String fullName, String code, String phoneNumber, String email, String city, String address, String speciality) {
        this.fullName = fullName;
        this.code = code;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.address = address;
        this.speciality = speciality;
    }
}