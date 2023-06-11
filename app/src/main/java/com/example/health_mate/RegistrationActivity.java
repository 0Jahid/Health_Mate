package com.example.health_mate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText edName, edUsername, edEmail, edPassword, edConfirmPassword;
    Button btnRegister;
    TextView tvExistingUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edName = findViewById(R.id.editTextRegName);
        edUsername = findViewById(R.id.editTextRegUsername);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegisterPassword);
        edConfirmPassword = findViewById(R.id.editTextRegisterConfirmPassword);
        btnRegister = findViewById(R.id.buttonRegister);
        tvExistingUser = findViewById(R.id.textViewExistingUser);

        tvExistingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirmPassword = edConfirmPassword.getText().toString();
                if (name.length() == 0 || username.length() == 0 || email.length() == 0 || password.length() == 0 || confirmPassword.length() == 0) {
                    Toast.makeText(RegistrationActivity.this, "Please enter all fields", Toast.LENGTH_LONG).show();
                } else{
                    if (password.compareTo(confirmPassword)==0) {
                        if(isValid(password)){
                            Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                        }
                        else{
                            Toast.makeText(RegistrationActivity.this, "Password must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 number", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        }
        else {
            for (int i = 0; i < passwordhere.length(); i++) {
                if (passwordhere.charAt(i) >= 'a' && passwordhere.charAt(i) <= 'z') {
                    f1 = 1;
                }
                else if (passwordhere.charAt(i) >= 'A' && passwordhere.charAt(i) <= 'Z') {
                    f2 = 1;
                }
                else if (passwordhere.charAt(i) >= '0' && passwordhere.charAt(i) <= '9') {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1) {
                return true;
            }
            else {
                return false;
            }
        }
    }

}