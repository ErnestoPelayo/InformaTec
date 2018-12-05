package com.example.macbook.informatec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class activity_actions extends AppCompatActivity {

    Button btnContest,btnConferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);

        btnContest= findViewById(R.id.btn_contestCreate);
        btnConferences=findViewById(R.id.btn_ConferencesCreate);

        btnContest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_actions.this,Activity_ContestAction.class));
            }
        });

        btnConferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_actions.this,Activity_ConferencesActions.class));
            }
        });

             }



}
