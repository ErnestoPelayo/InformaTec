package com.example.macbook.informatec.Network;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseHelper {

    private DatabaseReference databaseReference;
    private final  static String Events_Path="Eventos";
    private final  static String Conference_Path="Conference";

    private static class SingletonHolder{
        private static final FireBaseHelper INSTANCE = new FireBaseHelper();
    }

    public static FireBaseHelper getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public FireBaseHelper(){
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getDatabaseReference(){
            return databaseReference;

    }

    public DatabaseReference getEvents(String name){
        DatabaseReference databaseReference= null;
        databaseReference=databaseReference.getRoot().child(name);
        return  databaseReference;

    }



}