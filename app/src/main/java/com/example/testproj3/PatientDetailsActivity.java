package com.example.testproj3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PatientDetailsActivity extends AppCompatActivity {
    private TextView firstNameTextView, lastNameTextView, ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        // Find the TextViews in your layout
        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        ageTextView = findViewById(R.id.ageTextView);

        // Get the patient object from the intent
        Intent intent = getIntent();
        Patient patient = getIntent().getParcelableExtra("patient");

        // Display the patient's details in the TextViews
        firstNameTextView.setText(patient.getFirstName());
        lastNameTextView.setText(patient.getLastName());
        ageTextView.setText(patient.getBirthDate());
    }
}
