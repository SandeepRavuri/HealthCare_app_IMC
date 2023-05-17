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

public class MyDoctorsActivity extends AppCompatActivity {
    public DatabaseReference mno;
    Doctor doctor;
    ListView listView;
    MyDoctorAdapter myDoctorAdapter;
    RecyclerView recyclerView;
    ArrayList<Doctor> PlumbersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_doctors);

        recyclerView = findViewById(R.id.userListDoctor);
        PlumbersList = new ArrayList<>();
        mno = FirebaseDatabase.getInstance().getReferenceFromUrl("https://testproj3-12495-default-rtdb.firebaseio.com/").child("Registered Doctors");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myDoctorAdapter = new MyDoctorAdapter(this,PlumbersList);
        recyclerView.setAdapter(myDoctorAdapter);

        mno.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    doctor = ds.getValue(Doctor.class);
                    PlumbersList.add(doctor);
                }
                myDoctorAdapter.notifyDataSetChanged();
            }



            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });
    }
}