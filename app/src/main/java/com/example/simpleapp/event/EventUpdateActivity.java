package com.example.simpleapp.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.simpleapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventUpdateActivity extends AppCompatActivity {

    EditText event_name, event_description;
    Button update_button;
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update);

        Intent intent = getIntent();
        event_name = findViewById(R.id.update_event_name);
        event_description = findViewById(R.id.update_event_description);
        update_button = findViewById(R.id.update_event_button);

        event_name.setText(intent.getStringExtra("event_name"));
        event_description.setText(intent.getStringExtra("event_description"));

        update_button.setOnClickListener(v -> {
            rootRef.child("event").child(intent.getStringExtra("event_id")).child("name").setValue(event_name.getText().toString());
            rootRef.child("event").child(intent.getStringExtra("event_id")).child("description").setValue(event_description.getText().toString());
        });
    }
}