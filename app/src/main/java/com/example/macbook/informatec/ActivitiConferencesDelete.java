package com.example.macbook.informatec;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macbook.informatec.ui.Activity_ConferencesCreate;
import com.example.macbook.informatec.ui.Activity_ContestDelete;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ActivitiConferencesDelete extends AppCompatActivity {

    Button btn_deleteConference;
    EditText name_delete_conference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiti_conferences_delete);

        btn_deleteConference= findViewById(R.id.button_deleteConference);
        name_delete_conference= findViewById(R.id.editText_deleteConference);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Conference");

        btn_deleteConference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name_delete_conference.getText().toString();

                if (!TextUtils.isEmpty(name)){
                    Query q=databaseReference.orderByChild(getString(R.string.campo_name)).equalTo(name);

                    q.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){

                                String clave=datasnapshot.getKey();
                                DatabaseReference ref = databaseReference.child(clave);

                                ref.removeValue();
                            }
                            name_delete_conference.setText("");
                            Toast.makeText(ActivitiConferencesDelete.this, "Eliminado con Exito", Toast.LENGTH_LONG).show();

                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(ActivitiConferencesDelete.this, "ocurrio un problema", Toast.LENGTH_LONG).show();
                        }
                    });
                }

                else{
                    Toast.makeText(ActivitiConferencesDelete.this, "Debes introducir algo en el campo", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
