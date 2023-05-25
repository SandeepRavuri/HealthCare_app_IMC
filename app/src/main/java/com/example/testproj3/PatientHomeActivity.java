package com.example.testproj3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class PatientHomeActivity extends AppCompatActivity {

    CardView myDoctorsPage, emergencyPage, healthNewsPage, signOutPatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

        myDoctorsPage = findViewById(R.id.editMyDoctors);
        emergencyPage = findViewById(R.id.editEmergency);
        healthNewsPage = findViewById(R.id.editHealthNews);
        signOutPatient = findViewById(R.id.editSignoutPatient);

        Patient patient = getIntent().getParcelableExtra("patient");
        myDoctorsPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(PatientHomeActivity.this, MyDoctorsActivity.class));
                Intent intent = new Intent(v.getContext(),MyDoctorsActivity.class);
                intent.putExtra("patient", patient);
                v.getContext().startActivity(intent);
            }
        });

        emergencyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientHomeActivity.this, EmergencyActivity.class));
            }
        });

        healthNewsPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientHomeActivity.this, HealthNewsActivity.class));
            }
        });

        signOutPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientHomeActivity.this, LoginActivity.class));
            }
        });

    }
}