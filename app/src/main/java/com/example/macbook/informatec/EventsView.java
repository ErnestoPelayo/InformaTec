package com.example.macbook.informatec;

import com.example.macbook.informatec.Domain.model.Events;

import java.util.List;

public interface EventsView {
    void fillAdapter(List<Events> eventsList);
}
