package com.example.macbook.informatec.Presentador;

import com.example.macbook.informatec.Domain.EventsRepository;
import com.example.macbook.informatec.Domain.model.Events;
import com.example.macbook.informatec.EventsView;

import java.util.List;

public class ConferencesPresenterImplement implements EventsPresenter {

    private EventsView mView;
    private EventsRepository mRepository;

    public ConferencesPresenterImplement(EventsView view, EventsRepository repository) {
        mView = view;
        mRepository = repository;
    }

    @Override
    public void getEventsList() {

        mRepository.fetchEvents(
                new EventsRepository.GetEventsCallback(){
                    @Override
                    public void onDataLoaded(List<Events> events) {
                        mView.fillAdapter(events);
                    }
                }
        );
    }
}
