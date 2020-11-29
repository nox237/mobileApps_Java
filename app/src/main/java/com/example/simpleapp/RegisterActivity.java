package com.example.simpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button login = findViewById(R.id.buttonLogin);

        login.setOnClickListener(v -> {
            Context context = getApplicationContext();
            String email = ((EditText) findViewById(R.id.emailLogin)).getText().toString();
            String password = ((EditText) findViewById(R.id.passwordLogin)).getText().toString();
            Toast.makeText(context, "Not Connect to Firebase Yet. But the email is: " + email + " and the password is: " + password,Toast.LENGTH_SHORT).show();
        });
    }
}