package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleapp.event.EventAdapter;
import com.example.simpleapp.event.EventAddActivity;
import com.example.simpleapp.event.EventData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

//    FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener authStateListener;

    private RecyclerView recyclerView;
    DatabaseReference database;
    private EventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button logout = findViewById(R.id.buttonLogout);
        FloatingActionButton add_event = findViewById(R.id.add_event_button);

        List<EventData> list_event_name = new ArrayList<>();
        recyclerView = findViewById(R.id.rvlayout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        adapter = new EventAdapter(HomeActivity.this, list_event_name);
        recyclerView.setAdapter(adapter);

        database = FirebaseDatabase.getInstance().getReference().child("event");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list_event_name.clear();
                for (DataSnapshot snapshot1:snapshot.getChildren()) {
                    EventData eventData = snapshot1.getValue(EventData.class);
                    list_event_name.add(eventData);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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