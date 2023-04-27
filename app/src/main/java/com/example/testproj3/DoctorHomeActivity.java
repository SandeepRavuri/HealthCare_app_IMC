package com.example.testproj3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoctorHomeActivity extends AppCompatActivity {

    CardView patientPage, appointmentPage, signoutDoctor, uploadPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);

        patientPage = findViewById(R.id.editMyPatients);
        appointmentPage = findViewById(R.id.editMyAppointments);
        signoutDoctor = findViewById(R.id.editSignout);
        uploadPage = findViewById(R.id.editUploadData);

        patientPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorHomeActivity.this, MyPatientsActivity.class));
            }
        });

        appointmentPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorHomeActivity.this, MyAppointmentsActivity.class));
            }
        });

        uploadPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorHomeActivity.this, UploadActivity.class));
            }
        });

        signoutDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorHomeActivity.this, LoginActivity.class));
            }
        });
    }
}