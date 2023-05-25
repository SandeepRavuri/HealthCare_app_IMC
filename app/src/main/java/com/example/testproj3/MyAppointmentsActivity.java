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

public class MyAppointmentsActivity extends AppCompatActivity {
    public DatabaseReference mno;
    Appointment appointment;
    ListView listView;
    MyAppointmentAdapter myAppointmentAdapter;
    RecyclerView recyclerView;
    ArrayList<Appointment> PlumbersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments);

        recyclerView = findViewById(R.id.userListAppointment);
        PlumbersList = new ArrayList<>();
        mno = FirebaseDatabase.getInstance().getReferenceFromUrl("https://testproj4-da3d6-default-rtdb.firebaseio.com").child("appointments");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAppointmentAdapter = new MyAppointmentAdapter(this,PlumbersList);
        recyclerView.setAdapter(myAppointmentAdapter);

        mno.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    appointment = ds.getValue(Appointment.class);
                    PlumbersList.add(appointment);
                }
                myAppointmentAdapter.notifyDataSetChanged();
            }

            @Override

            public void onCancelled(DatabaseError firebaseError) {

            }
        });
    }
}
