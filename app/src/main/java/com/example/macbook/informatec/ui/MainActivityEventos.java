package com.example.macbook.informatec.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.macbook.informatec.data.network.MyAdapter;
import com.example.macbook.informatec.data.models.Events;
import com.example.macbook.informatec.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivityEventos extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<Events> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eventos);

        recyclerView =findViewById(R.id.myRecyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Events>();

        reference = FirebaseDatabase.getInstance().getReference().child("Eventos");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {

                    Events p= dataSnapshot1.getValue(Events.class);
                    list.add(p);

                }

                adapter = new MyAdapter(MainActivityEventos.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivityEventos.this,"Salio algo mal",Toast.LENGTH_LONG).show();
            }
        });



    }
}


