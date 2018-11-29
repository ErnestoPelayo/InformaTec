package com.example.macbook.informatec.Presentador;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.macbook.informatec.Adapters.MyAdapter;
import com.example.macbook.informatec.Models.Events;
import com.example.macbook.informatec.MvpInformatec;
import com.example.macbook.informatec.View.ActivityContest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Presenter {

    public Events events;
    public ArrayList<Events> list;
    public Context context;
    public MyAdapter adapter;
    public ActivityContest c;


    public MyAdapter getAdapter() {
        return adapter;
    }

     public ArrayList<Events> getList() {
        return list;

    }


    public void setList(ArrayList<Events> list) {
        this.list = list;
    }

    public Presenter(Context context) {
        this.context = context;
    }
<<<<<<< HEAD
    
=======

>>>>>>> af37d6a8e8fd3c37b55ded94d8adeaecafdfa398
    @Override
    public void getDatosFireBase(final DatabaseReference databaseReference) {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Events p= snapshot.getValue(Events.class);
                    list.add(p);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
