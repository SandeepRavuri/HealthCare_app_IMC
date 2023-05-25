package com.example.testproj3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorDetailsActivity extends AppCompatActivity {

    private TextView textViewFullName;
    private TextView textViewCode;
    private TextView textViewPhoneNumber;
    private TextView textViewEmail;
    private TextView textViewCity;
    private TextView textViewAddress;
    private TextView textViewSpeciality;

    private Button  buttonBookAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        // Get the Doctor object from the intent
        Doctor doctor = getIntent().getParcelableExtra("doctor");
        Patient patient = getIntent().getParcelableExtra("patient");

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

        // Initialize the "Book Appointment" button
        buttonBookAppointment = findViewById(R.id.buttonAppointment);
        buttonBookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the booking appointment activity
                Intent intent = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                intent.putExtra("doctor", doctor);
                intent.putExtra("patient", patient);
                startActivity(intent);
            }
        });
    }
}
