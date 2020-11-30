package com.example.simpleapp;

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

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.buttonLogin);
        TextView register = findViewById(R.id.registerLink);

        mAuthStateListener = firebaseAuth -> {
            FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
            if (mFirebaseUser != null){
                Toast.makeText(LoginActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(LoginActivity.this, "Cannot logged in",Toast.LENGTH_SHORT).show();
            }
        };

        register.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            LoginActivity.this.startActivity(i);
        });

        login.setOnClickListener(v -> {
            String email = ((EditText) findViewById(R.id.emailLogin)).getText().toString();
            String password = ((EditText) findViewById(R.id.passwordLogin)).getText().toString();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, task -> {
                 if (!task.isSuccessful()){
                     Toast.makeText(LoginActivity.this, "Login Error, Please Login again", Toast.LENGTH_SHORT).show();
                 } else {
                     Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                     Intent home = new Intent(LoginActivity.this, HomeActivity.class);
                     startActivity(home);
                 }
            });
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }
}