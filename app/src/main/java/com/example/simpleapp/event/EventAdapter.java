package com.example.simpleapp.event;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleapp.HomeActivity;
import com.example.simpleapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context context;
    private List<EventData> list_event_name;

    public EventAdapter(Context context, List<EventData> list_event_name){
        this.context = context;
        this.list_event_name = list_event_name;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_event, parent, false);
        EventViewHolder holder = new EventViewHolder(view);

        holder.update_button.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), EventUpdateActivity.class);

            intent.putExtra("event_id", list_event_name.get(holder.getAdapterPosition()).getId());
            intent.putExtra("event_name", list_event_name.get(holder.getAdapterPosition()).getName());
            intent.putExtra("event_description",list_event_name.get(holder.getAdapterPosition()).getDescription());

            v.getContext().startActivity(intent);
        });

        holder.delete_button.setOnClickListener(v -> {
            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            rootRef.child("event").child(list_event_name.get(holder.getAdapterPosition()).getId()).getRef().removeValue();
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.name.setText(list_event_name.get(position).getName());
        holder.description.setText(list_event_name.get(position).getDescription());
    }
    @Override
    public int getItemCount() {
        return list_event_name.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public FloatingActionButton delete_button;
        public Button update_button;

        public EventViewHolder(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.event_title);
            description = v.findViewById(R.id.event_description);
            delete_button = v.findViewById(R.id.delete_event_button);
            update_button = v.findViewById(R.id.edit_data);
        }
    }
}
