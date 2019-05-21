package com.example.macbook.informatec.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.macbook.informatec.Domain.Adapters.MyAdapter;
import com.example.macbook.informatec.Domain.ConferencesRepositoryImplement;
import com.example.macbook.informatec.Domain.ContestRepositoryImplement;
import com.example.macbook.informatec.EventsView;
import com.example.macbook.informatec.Presentador.ConferencesPresenterImplement;
import com.example.macbook.informatec.Presentador.ContestPresenterImplement;
import com.example.macbook.informatec.Presentador.EventsPresenter;
import com.example.macbook.informatec.R;
import com.example.macbook.informatec.Domain.model.Events;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class ActivityConferences extends AppCompatActivity implements EventsView {


    RecyclerView recyclerView;
    ArrayList<Events> list;
    MyAdapter adapter;
    EventsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_concursos);

        recyclerView =findViewById(R.id.myRecyclerView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Events>();
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // Create a Presenter instance
        presenter = new ConferencesPresenterImplement( this, new ConferencesRepositoryImplement());
        presenter.getEventsList();




    }

    @Override
    public void fillAdapter(List<Events> eventsList) {
        adapter.addEvents(eventsList);
    }
}

