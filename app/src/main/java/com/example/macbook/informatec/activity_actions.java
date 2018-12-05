package com.example.macbook.informatec;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.macbook.informatec.ui.MainActivity;

public class activity_actions extends AppCompatActivity {

    Button btnContest,btnConferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);

        btnContest= findViewById(R.id.btn_contestAction);
        btnConferences=findViewById(R.id.btn_conferencesActions);

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
