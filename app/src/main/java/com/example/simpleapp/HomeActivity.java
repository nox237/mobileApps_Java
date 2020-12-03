package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleapp.event.EventAddActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

//    FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button logout = findViewById(R.id.buttonLogout);
        FloatingActionButton add_event = findViewById(R.id.add_event_button);

        add_event.setOnClickListener(v -> {
            Intent add_event_activity = new Intent(HomeActivity.this, EventAddActivity.class);
            startActivity(add_event_activity);
        });

        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent login = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(login);
        });
    }
}