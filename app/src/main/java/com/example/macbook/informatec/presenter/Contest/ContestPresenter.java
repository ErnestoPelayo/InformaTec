package com.example.macbook.informatec.presenter.Contest;

import com.example.macbook.informatec.Adapters.MyAdapter;
import com.example.macbook.informatec.model.Events;
import com.example.macbook.informatec.view.EventsContract;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ContestPresenter implements EventsContract.Presentator {

    private EventsContract.View mView;

    private ContestIterator interactor;

    DatabaseReference reference;
    ArrayList<Events> list;
    MyAdapter adapter;

    public ContestPresenter(final EventsContract.View view) {
        mView = view;
        interactor = new ContestIterator(this);
    }

    @Override
    public void refreshCurrentDates(ArrayList<Events> currentDates) {
      //  Collections.sort(currentDates);
        mView.refreshCurrentChatList(currentDates);

    }
}
