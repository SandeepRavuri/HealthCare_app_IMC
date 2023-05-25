package com.example.testproj3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAppointmentAdapter extends RecyclerView.Adapter<MyAppointmentAdapter.MyViewHolder> {
    Context context;
    ArrayList<Appointment> list;
    public MyAppointmentAdapter(Context context, ArrayList<Appointment> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MyAppointmentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.appointment,parent,false);
        MyViewHolder  viewHolder = new MyViewHolder(v);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAppointmentAdapter.MyViewHolder holder, int position) {
        Appointment user = list.get(position);
        holder.patientName.setText(user.getPatientName());
        holder.doctorName.setText(user.getDoctorName());
        holder.date.setText(user.getAppointmentDate());
        holder.time.setText(user.getAppointmentTime());
    }

    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView patientName, doctorName, date, time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            doctorName = itemView.findViewById(R.id.editDoctorName);
            patientName = itemView.findViewById(R.id.editPatientName);
            date = itemView.findViewById(R.id.editDate);
            time = itemView.findViewById(R.id.editTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                }
            });

        }

    }
}