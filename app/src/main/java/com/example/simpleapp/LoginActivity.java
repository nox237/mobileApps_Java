package com.example.simpleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

        Button login = findViewById(R.id.buttonLogin);
        TextView register = findViewById(R.id.registerLink);

        register.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            LoginActivity.this.startActivity(i);
        });

        login.setOnClickListener(v -> {
            Context context = getApplicationContext();
            String email = ((EditText) findViewById(R.id.emailLogin)).getText().toString();
            String password = ((EditText) findViewById(R.id.passwordLogin)).getText().toString();
            Toast.makeText(context, "Not Connect to Firebase Yet. But the email is: " + email + " and the password is: " + password,Toast.LENGTH_SHORT).show();
        });
    }
}