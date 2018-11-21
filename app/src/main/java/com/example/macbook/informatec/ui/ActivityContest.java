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
import com.example.macbook.informatec.model.Events;
import com.example.macbook.informatec.R;
import com.example.macbook.informatec.MvpInformatec;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityContest extends AppCompatActivity  {

    RecyclerView recyclerView;
    DatabaseReference reference;
    MyAdapter adapter;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_concursos);

        recyclerView =findViewById(R.id.myRecyclerView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reference = FirebaseDatabase.getInstance().getReference().child("Eventos");

        Presenter p= new Presenter(this);
        p.getDatosFireBase(reference);
        recyclerView.setAdapter(p.getAdapter());


    }
    }

