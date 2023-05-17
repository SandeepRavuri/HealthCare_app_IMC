package com.example.testproj3;
import android.os.Parcel;
import android.os.Parcelable;

public class Doctor implements Parcelable {
    private String fullName;
    private String code;
    private String phoneNumber;
    private String email;
    private String city;
    private String address;
    private String speciality;

    public Doctor(){

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

    protected Doctor(Parcel in) {
        fullName = in.readString();
        code = in.readString();
        phoneNumber = in.readString();
        email = in.readString();
        city = in.readString();
        address = in.readString();
        speciality = in.readString();
    }

    public static final Creator<Doctor> CREATOR = new Creator<Doctor>() {
        @Override
        public Doctor createFromParcel(Parcel in) {
            return new Doctor(in);
        }

        @Override
        public Doctor[] newArray(int size) {
            return new Doctor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(code);
        dest.writeString(phoneNumber);
        dest.writeString(email);
        dest.writeString(city);
        dest.writeString(address);
        dest.writeString(speciality);
    }

    public String getFullName() {
        return fullName;
    }

    public String getCode() {
        return code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getSpeciality() {
        return speciality;
    }
}
