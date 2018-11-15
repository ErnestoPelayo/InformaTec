package com.example.macbook.informatec.presenter.Contest;

import com.example.macbook.informatec.model.Events;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ContestIterator {


    private static final String TAG = ContestIterator.class.getSimpleName();
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Events");

    private ContestPresenter presenter;

    private ArrayList<Events> mCurrentEvents = new ArrayList<>();


    ContestIterator(ContestPresenter presenter){
        this.presenter=presenter;
        retrieveCurrentDates();

    }
    private void retrieveCurrentDates() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mCurrentEvents.clear();

                for (DataSnapshot messagesSnapshot : dataSnapshot.getChildren()) {
                    Events events = messagesSnapshot.getValue(Events.class);
                    mCurrentEvents.add(events);
                }

                presenter.refreshCurrentDates(mCurrentEvents);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //TODO: Handle error on presenter here.
            }
        });
    }

}
