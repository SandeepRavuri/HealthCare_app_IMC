package com.example.testproj3;


public class Patient {
    public String FirstName, lastName, birthDate, phoneNumber, email, password;

    public Patient(){

    }
    public Patient(String firstName, String lastName, String birthDate, String phoneNumber, String email, String password) {
        this.FirstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

}