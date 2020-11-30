package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

//    FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button logout = findViewById(R.id.buttonLogout);

        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent login = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(login);
        });
    }
}