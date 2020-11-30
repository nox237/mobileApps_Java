package com.example.simpleapp;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button register = findViewById(R.id.buttonRegister);
        TextView login = findViewById(R.id.loginLink);

        login.setOnClickListener(v -> onBackPressed());

        register.setOnClickListener(v -> {
            Context context = getApplicationContext();
            String name = ((EditText) findViewById(R.id.nameRegister)).getText().toString();
            String email = ((EditText) findViewById(R.id.emailRegister)).getText().toString();
            String password = ((EditText) findViewById(R.id.passwordRegister)).getText().toString();
            String confPassword = ((EditText) findViewById(R.id.confPasswordRegister)).getText().toString();
            Toast.makeText(context, "Not Connect to Firebase Yet. But the email is: " + email + " and the password is: " + password,Toast.LENGTH_SHORT).show();
        });
    }
}