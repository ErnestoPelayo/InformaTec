package com.example.macbook.informatec.view;

import com.example.macbook.informatec.model.Events;

import java.util.ArrayList;
import java.util.Collections;

public interface EventsContract {

    interface View{
        void refreshCurrentChatList(ArrayList<Events> currentDates);

    }

    interface Presentator{

        void refreshCurrentDates(ArrayList<Events> currentDatesb);


    }

}
