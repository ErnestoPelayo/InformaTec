package com.example.macbook.informatec;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macbook.informatec.ui.Activity_ContestDelete;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Activity_ContestUpdate extends AppCompatActivity {

    EditText editTextBuscar,editTextnameSearch,editTextdateSearch;
    Button btnsearch;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__contest_update);

        editTextBuscar= findViewById(R.id.editText_search);
        btnsearch=findViewById(R.id.btn_searchContest);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Contest");


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=editTextBuscar.getText().toString();

                if (!TextUtils.isEmpty(name)){
                    Query q=databaseReference.orderByChild("name").equalTo(name);

                    q.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){

                                String clave=datasnapshot.getKey();
                                DatabaseReference ref = databaseReference.child(clave);

                                editTextnameSearch.setText("");
                                ref.removeValue();
                            }
                       //     name_delete.setText("");

                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(Activity_ContestUpdate.this, "ocurrio un problema", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

    }
}
