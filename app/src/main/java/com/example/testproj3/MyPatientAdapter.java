package com.example.testproj3;

import android.content.Intent;
import android.view.ViewGroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class MyPatientAdapter extends RecyclerView.Adapter<MyPatientAdapter.MyViewHolder> {

    Context context;

    ArrayList<Patient> list;


    public MyPatientAdapter(Context context, ArrayList<Patient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.patients,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);


        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Patient user = list.get(position);
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.age.setText(user.getBirthDate());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView firstName, lastName, age;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.tvfirstName);
            lastName = itemView.findViewById(R.id.tvlastName);
            age = itemView.findViewById(R.id.tvage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Patient patient = list.get(position);

                        // Start a new activity and pass the patient details
                        Intent intent = new Intent(v.getContext(), PatientDetailsActivity.class);
                        intent.putExtra("patient",patient);
                        v.getContext().startActivity(intent);
                    }
                }
            });

        }

}
}