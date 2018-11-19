package com.example.macbook.informatec.Presentador;

import com.example.macbook.informatec.model.Events;
import com.example.macbook.informatec.MvpInformatec;

public class Presenter implements MvpInformatec.Presenter {

    private MvpInformatec mview;
    private Events events;

    public Presenter(){
        events=new Events();
    }

    @Override
    public void setView(MvpInformatec.View view) {
        mview = (MvpInformatec) view;
    }

}
