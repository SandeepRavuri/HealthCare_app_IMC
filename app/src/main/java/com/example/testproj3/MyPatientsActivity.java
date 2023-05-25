package com.example.testproj3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyPatientsActivity extends AppCompatActivity {

    public DatabaseReference mno;
    Patient patient;
    ListView listView;
    MyPatientAdapter myPatientAdapter;
    RecyclerView recyclerView;
    ArrayList<Patient> PlumbersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_patients);

        recyclerView = findViewById(R.id.userList);
        PlumbersList = new ArrayList<>();
        mno = FirebaseDatabase.getInstance().getReferenceFromUrl("https://testproj4-da3d6-default-rtdb.firebaseio.com").child("Registered Patients");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myPatientAdapter = new MyPatientAdapter(this,PlumbersList);
        recyclerView.setAdapter(myPatientAdapter);

        mno.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    patient = ds.getValue(Patient.class);
                    PlumbersList.add(patient);
                }
                myPatientAdapter.notifyDataSetChanged();
            }

            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });
    }
}