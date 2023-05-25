package com.example.testproj3;

import android.os.Parcel;
import android.os.Parcelable;

public class Appointment implements Parcelable {
    private String appointmentId;
    private String doctorName;
    private String patientName;
    private String appointmentDate;

    private String appointmentTime;

    public Appointment() {
        // Default constructor required for Firebase database
    }

    public Appointment(String appointmentId, String doctorName, String patientName, String appointmentDate, String appointmentTime) {
        this.appointmentId = appointmentId;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    protected Appointment(Parcel in) {
        appointmentId = in.readString();
        doctorName = in.readString();
        patientName = in.readString();
        appointmentDate = in.readString();
        appointmentTime = in.readString();
    }

    public static final Creator<Appointment> CREATOR = new Creator<Appointment>() {
        @Override
        public Appointment createFromParcel(Parcel in) {
            return new Appointment(in);
        }

        @Override
        public Appointment[] newArray(int size) {
            return new Appointment[size];
        }
    };

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime(){return appointmentTime;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(appointmentId);
        dest.writeString(doctorName);
        dest.writeString(patientName);
        dest.writeString(appointmentDate);
        dest.writeString(appointmentTime);
    }
}
