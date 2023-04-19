package com.example.testproj3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName, password;
    Button login;
    TextView register;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.editUserName);
        password = findViewById(R.id.editPassword);
        login = findViewById(R.id.editLogin);
        register = findViewById(R.id.editRegister);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = userName.getText().toString();
                String Password = password.getText().toString();
                // Database db = new Database(getApplicationContext(), "Users Table", null , 1);
                if(UserName.length() == 0 || Password.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please enter all details", Toast.LENGTH_SHORT).show();
                }else{
                    //if(isValid(password)){
                    // db.register(firstName,lastName);
                    //Count.setText(db.count(firstName,lastName));
                    Toast.makeText(getApplicationContext(), "Submitted Request", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    // }

                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });



    }
}