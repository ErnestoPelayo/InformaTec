package com.example.macbook.informatec.Domain.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.macbook.informatec.R;
import com.example.macbook.informatec.Domain.model.Events;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Events> dataset;

    public MyAdapter() {
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Events events = dataset.get(position);
        holder.name.setText(events.getName());
        holder.ubication.setText(events.getUbication());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addEvents(List<Events> eventsList) {
        Log.d("ENTRARON", "Tam " + eventsList.size());
        dataset.addAll(eventsList);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        CardView date;
        TextView name,ubication;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.text_name);
            ubication = itemView.findViewById(R.id.ubication);
            date = itemView.findViewById(R.id.cardview);
        }





    }


}
