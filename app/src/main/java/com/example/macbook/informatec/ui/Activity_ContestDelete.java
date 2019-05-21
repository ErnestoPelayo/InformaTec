package com.example.macbook.informatec.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macbook.informatec.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Activity_ContestDelete extends AppCompatActivity {

    Button btn_deleteContest;
    EditText name_delete;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__contest_delete);

        btn_deleteContest= findViewById(R.id.btn_deleteContest);
        name_delete= findViewById(R.id.editTextDelete_name);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Contest");

        btn_deleteContest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name_delete.getText().toString();

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
                            name_delete.setText("");
                            Toast.makeText(Activity_ContestDelete.this, "Eliminado con Exito", Toast.LENGTH_LONG).show();

                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(Activity_ContestDelete.this, "ocurrio un problema", Toast.LENGTH_LONG).show();
                        }
                    });
                }

                else{
                    Toast.makeText(Activity_ContestDelete.this, "Debes introducir algo en el campo", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
