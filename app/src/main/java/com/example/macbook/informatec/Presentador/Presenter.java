package com.example.macbook.informatec.Presentador;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.macbook.informatec.Adapters.MyAdapter;
import com.example.macbook.informatec.model.Events;
import com.example.macbook.informatec.MvpInformatec;
import com.example.macbook.informatec.ui.ActivityContest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Presenter implements MvpInformatec {

    private Events events;
    ArrayList<Events> list;
    Context context;
    MyAdapter adapter;
    ActivityContest c;


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
    
    @Override
    public void getDatosFireBase(final DatabaseReference databaseReference) {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Events p= snapshot.getValue(Events.class);
                    list.add(p);
                }
                adapter=new MyAdapter(adapter.getContext(),list);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
