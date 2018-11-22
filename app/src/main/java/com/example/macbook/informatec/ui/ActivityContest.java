package com.example.macbook.informatec.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.macbook.informatec.Adapters.MyAdapter;
import com.example.macbook.informatec.Presentador.Presenter;
import com.example.macbook.informatec.model.Contest;
import com.example.macbook.informatec.model.Events;
import com.example.macbook.informatec.R;
import com.example.macbook.informatec.MvpInformatec;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityContest extends AppCompatActivity implements MvpInformatec {

    RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<Contest> list;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_concursos);

        recyclerView =findViewById(R.id.myRecyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Contest>();
        reference = FirebaseDatabase.getInstance().getReference().child("Eventos");
        if(reference!=null){
            getDatosFireBase(reference);
        }

    }



    @Override
    public void getDatosFireBase(DatabaseReference databaseReference) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Contest t= dataSnapshot1.getValue(Contest.class);
                    list.add(t);
                }

                adapter = new MyAdapter(ActivityContest.this,list);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ActivityContest.this,"Salio algo mal",Toast.LENGTH_LONG).show();
            }
        });

    }
}

