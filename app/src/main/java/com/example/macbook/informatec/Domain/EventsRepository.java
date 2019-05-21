package com.example.macbook.informatec.Domain;

import com.example.macbook.informatec.Domain.model.Events;

import java.util.List;

public interface EventsRepository {
    interface GetEventsCallback {
        void onDataLoaded(List<Events> events);
    }

    void fetchEvents(GetEventsCallback callback);

}
