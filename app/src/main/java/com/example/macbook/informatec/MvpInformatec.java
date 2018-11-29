package com.example.macbook.informatec;

public interface MvpInformatec {

    interface View{
        void conectionFireBase();

    }

    interface Presenter{
        void setView(MvpInformatec.View view);

    }

}
