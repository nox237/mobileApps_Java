package com.example.simpleapp.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.simpleapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventAddActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);

        Button submit_button = findViewById(R.id.update_event_button);

        submit_button.setOnClickListener(v -> {
            String title = ((EditText) findViewById(R.id.update_event_name)).getText().toString();
            String description = ((EditText) findViewById(R.id.update_event_description)).getText().toString();
            String image = ((EditText) findViewById(R.id.add_image_url)).getText().toString();
            uploadData(title, description, image);
        });
    }

    private void uploadData(String title, String description, String image){
        DatabaseReference eventRef = database.getReference("event").push();
        eventRef.setValue(new EventData(eventRef.getKey(), title, description, image));
    }
}