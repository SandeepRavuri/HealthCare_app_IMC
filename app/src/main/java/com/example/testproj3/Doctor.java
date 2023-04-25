package com.example.testproj3;

public class Doctor {
    private String fullName;
    private String code;
    private String phoneNumber;
    private String email;
    private String city;
    private String address;
    private String speciality;

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