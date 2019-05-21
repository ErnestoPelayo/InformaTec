package com.example.macbook.informatec.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macbook.informatec.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Activity_ConferencesCreate extends AppCompatActivity {

    Button btn_Save;
    EditText txt_name,txt_date,txt_ubication,txt_information;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__conferences_actions);


        btn_Save= findViewById(R.id.btn_saveConferences);
        txt_name=findViewById(R.id.editTextNameConferences);
        txt_date=findViewById(R.id.editTextDateConferences);
        txt_ubication=findViewById(R.id.editTextUbicationConferences);
        txt_information=findViewById(R.id.editTextInformationConference);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=txt_name.getText().toString();
                String date=txt_date.getText().toString();
                String ubication=txt_ubication.getText().toString();
                String information=txt_information.getText().toString();


                Map<String, Object> datesContest = new HashMap<>();
                datesContest.put("name",name);
                datesContest.put("date",date);
                datesContest.put("ubication",ubication);
                datesContest.put("information",information);


                databaseReference.child("Conferences").push().setValue(datesContest);

                txt_date.setText("");
                txt_information.setText("");
                txt_name.setText("");
                txt_ubication.setText("");

                Toast.makeText(Activity_ConferencesCreate.this, "Se agrego correctamente", Toast.LENGTH_LONG).show();

            }
        });

    }
}
