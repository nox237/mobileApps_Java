package com.example.simpleapp;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private void updateUI(FirebaseUser currentUser) {
        Context context = getApplicationContext();
        Toast.makeText(context, "User Login: "+currentUser.getDisplayName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button register = findViewById(R.id.buttonRegister);

        register.setOnClickListener(v -> {
            Context context = getApplicationContext();
            String name = ((EditText) findViewById(R.id.nameRegister)).getText().toString();
            String email = ((EditText) findViewById(R.id.emailRegister)).getText().toString();
            String password = ((EditText) findViewById(R.id.passwordRegister)).getText().toString();
            String confirmationPassword = ((EditText) findViewById(R.id.confPasswordRegister)).getText().toString();
            Toast.makeText(context, "Not Connect to Firebase Yet. But the email is: " + email + " and the password is: " + password,Toast.LENGTH_SHORT).show();
        });
    }
}