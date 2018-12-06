package com.example.macbook.informatec.Domain;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.example.macbook.informatec.Domain.model.Events;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ContestRepositoryImplement implements EventsRepository {

    private FirebaseHelper helper;
    private final static String KEY = "Contest";
    private ExecutorService executor;


    public ContestRepositoryImplement(){
        helper = FirebaseHelper.getInstance();
        executor = Executors.newSingleThreadExecutor();
    }

    @Override
    public void fetchEvents(final GetEventsCallback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                helper.getDatabaseReference().child(KEY).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List<Events> eventsList = new ArrayList<>();
                        for (DataSnapshot o : dataSnapshot.getChildren()) {
                            Events events = o.getValue(Events.class);
                            eventsList.add(events);
                        }
                        callback.onDataLoaded(eventsList);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }



}
