package com.example.simpleapp.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleapp.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context context;
    private List<EventData> list_event_name;

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;

        public EventViewHolder(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.event_title);
            description = v.findViewById(R.id.event_description);
        }
    }

    public EventAdapter(Context context, List<EventData> list_event_name){
        this.context = context;
        this.list_event_name = list_event_name;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
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
}
