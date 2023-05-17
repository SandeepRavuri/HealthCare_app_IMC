package com.example.testproj3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DoctorDetailsActivity extends AppCompatActivity {

    private TextView textViewFullName;
    private TextView textViewCode;
    private TextView textViewPhoneNumber;
    private TextView textViewEmail;
    private TextView textViewCity;
    private TextView textViewAddress;
    private TextView textViewSpeciality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        // Get the Doctor object from the intent
        Doctor doctor = getIntent().getParcelableExtra("doctor");

        // Initialize TextViews
        textViewFullName = findViewById(R.id.textViewFullName);
        textViewCode = findViewById(R.id.textViewCode);
        textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewCity = findViewById(R.id.textViewCity);
        textViewAddress = findViewById(R.id.textViewAddress);
        textViewSpeciality = findViewById(R.id.textViewSpeciality);

        // Set the Doctor details in the TextViews
        textViewFullName.setText(doctor.getFullName());
        textViewCode.setText(doctor.getCode());
        textViewPhoneNumber.setText(doctor.getPhoneNumber());
        textViewEmail.setText(doctor.getEmail());
        textViewCity.setText(doctor.getCity());
        textViewAddress.setText(doctor.getAddress());
        textViewSpeciality.setText(doctor.getSpeciality());
    }
}
