package com.example.testproj3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    private TextView textViewDoctorName;
    private Button buttonSelectDate;
    private TextView textViewSelectedDate, textViewSelectedTime;
    private EditText editTextPatientName;
    private Button buttonBookAppointment;

    private Calendar selectedDate, selectedTime;

    private Button btnDatePicker, btnTimePicker, btnScheduleAppointment;
    private int year, month, day, hour, minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        // Get the Doctor object from the intent
        Doctor doctor = getIntent().getParcelableExtra("doctor");
        Patient patient = getIntent().getParcelableExtra("patient");



        // Initialize views
        btnTimePicker = findViewById(R.id.btnTimePicker);
        textViewDoctorName = findViewById(R.id.textViewDoctorName);
        textViewSelectedTime = findViewById(R.id.textViewSelectedTime);
        buttonSelectDate = findViewById(R.id.buttonSelectDate);
        textViewSelectedDate = findViewById(R.id.textViewSelectedDate);
        buttonBookAppointment = findViewById(R.id.buttonBookAppointment);
        editTextPatientName= findViewById(R.id.editTextPatientName);

        textViewDoctorName.setText(doctor.getFullName()); // Replace with your logic to get the doctor nam
        // Set click listener for selecting the appointment date
        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get current time
                final Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);

                // Show TimePickerDialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(BookAppointmentActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // Store selected time
                                hour = hourOfDay;
                                BookAppointmentActivity.this.minute = minute;
                                selectedTime = Calendar.getInstance();
                                selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                selectedTime.set(Calendar.MINUTE, minute);
                                updateSelectedTimeTextView();
                                Toast.makeText(BookAppointmentActivity.this, "Selected time: " + hour + ":" + minute, Toast.LENGTH_SHORT).show();
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        buttonBookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the booking appointment logic
                // You can access the selectedDate and perform the necessary actions here


                String doctorName = textViewDoctorName.getText().toString();
                String patientName = editTextPatientName.getText().toString(); // Replace with the actual patient name

                // Get the selected date from textViewSelectedDate
                String appointmentDate = textViewSelectedDate.getText().toString();
                String appointmentTime = textViewSelectedTime.getText().toString();

                // Initialize Firebase database reference
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference appointmentsRef = database.getReference("appointments");

                // Create a new appointment node with a unique key
                String appointmentId = appointmentsRef.push().getKey();

                // Create an Appointment object with the appointment details
                Appointment appointment = new Appointment(appointmentId, doctorName, patientName, appointmentDate,appointmentTime);

                // Store the appointment in the Firebase database
                appointmentsRef.child(appointmentId).setValue(appointment);

                startActivity(new Intent(BookAppointmentActivity.this, MyDoctorsActivity.class));

            }
        });
    }

    private void showDatePickerDialog() {
        Calendar currentDate = Calendar.getInstance();
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);
        int dayOfMonth = currentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        selectedDate = Calendar.getInstance();
                        selectedDate.set(year, month, dayOfMonth);

                        // Update the selected date text view
                        updateSelectedDateTextView();
                    }
                }, year, month, dayOfMonth);

        // Set the minimum date to today's date
        datePickerDialog.getDatePicker().setMinDate(currentDate.getTimeInMillis());

        // Show the date picker dialog
        datePickerDialog.show();
    }

    private void updateSelectedDateTextView() {
        if (selectedDate != null) {
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
            String formattedDate = dateFormat.format(selectedDate.getTime());
            textViewSelectedDate.setText(formattedDate);
        } else {
            textViewSelectedDate.setText("");
        }
    }

    private void updateSelectedTimeTextView() {
        if (selectedTime != null) {
            DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
            String formattedTime = timeFormat.format(selectedTime.getTime());
            textViewSelectedTime.setText(formattedTime);
        } else {
            textViewSelectedTime.setText("");
        }
    }
}
