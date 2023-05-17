package com.example.testproj3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyDoctorAdapter extends RecyclerView.Adapter<MyDoctorAdapter.MyViewHolder> {

    Context context;
    ArrayList<Doctor> list;

    public MyDoctorAdapter(Context context, ArrayList<Doctor> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.doctor,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        // Set the click listener for the item view
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDoctorAdapter.MyViewHolder holder, int position) {
        Doctor user = list.get(position);
        holder.firstName.setText(user.getFullName());
        holder.speciality.setText(user.getSpeciality());
        holder.city.setText(user.getCity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView firstName, speciality, city;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.tvfirstName);
            speciality = itemView.findViewById(R.id.tvlastName);
            city = itemView.findViewById(R.id.tvage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle the item click event here
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Doctor doctor = list.get(position);

                        // Start a new activity and pass the patient details
                        Intent intent = new Intent(view.getContext(), DoctorDetailsActivity.class);
                        intent.putExtra("doctor",doctor);
                        view.getContext().startActivity(intent);
                    }
                    // Perform the desired action for the clicked item
                }
            });

        }
    }

}