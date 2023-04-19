package com.example.testproj3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText firstName, lastName, newPassword, confirmPassword;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Set the Title for Page
        getSupportActionBar().setTitle("Register");
        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editLastName);
        newPassword = findViewById(R.id.editNewPassword);
        confirmPassword = findViewById(R.id.editConfirmPassword);
        next = findViewById(R.id.editNext);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FirstName = firstName.getText().toString();
                String LastName = lastName.getText().toString();
                String new_psd = newPassword.getText().toString();
                String confirm_psd = confirmPassword.getText().toString();

                if (TextUtils.isEmpty(FirstName)){
                    Toast.makeText(RegisterActivity.this, "Please enter your First name", Toast.LENGTH_SHORT).show();
                    firstName.setError("First Name is required");
                    firstName.requestFocus();
                } else if (TextUtils.isEmpty(LastName)){
                    Toast.makeText(RegisterActivity.this,"Please enter your Last name",Toast.LENGTH_SHORT).show();
                    lastName.setError("Last Name is required");
                    lastName.requestFocus();
                }else if(TextUtils.isEmpty(new_psd)){
                    Toast.makeText(RegisterActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    newPassword.setError("Password required");
                    newPassword.requestFocus();
                }else if(TextUtils.isEmpty(confirm_psd)){
                    Toast.makeText(RegisterActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    confirmPassword.setError("Password required");
                    confirmPassword.requestFocus();
                }else if (!new_psd.equals(confirm_psd)) {
                    Toast.makeText(RegisterActivity.this, "Please enter same password", Toast.LENGTH_SHORT).show();
                    confirmPassword.setError("Re-enter correct password");
                    newPassword.clearComposingText();
                    confirmPassword.clearComposingText();
                }else
                        registerUser(FirstName, LastName, new_psd, confirm_psd);
                        //startActivity(new Intent(RegisterActivity.this,PersonalRegisterActivity.class));
            }
        });

    }

    private void registerUser(String firstName, String lastName, String new_psd, String confirm_psd) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(firstName, confirm_psd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "user registered successfully", Toast.LENGTH_SHORT).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    firebaseUser.sendEmailVerification();
                }
            }
        });
    }
}