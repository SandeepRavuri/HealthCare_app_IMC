package com.example.testproj3;
import android.os.Parcel;
import android.os.Parcelable;

public class Patient implements Parcelable {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phoneNumber;
    private String email;
    private String password;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String birthDate, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    protected Patient(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        birthDate = in.readString();
        phoneNumber = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(birthDate);
        dest.writeString(phoneNumber);
        dest.writeString(email);
        dest.writeString(password);
    }
}
