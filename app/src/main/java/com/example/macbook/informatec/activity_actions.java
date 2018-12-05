package com.example.macbook.informatec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.macbook.informatec.ui.Activity_ConferencesCreate;
import com.example.macbook.informatec.ui.Activity_ContestCreate;
import com.example.macbook.informatec.ui.Activity_ContestDelete;

public class activity_actions extends AppCompatActivity {

    Button btnContestCreate,btnConferencesCreate,btnDeleteContest,btnDeleteConferences,btnUpdateContest,btnUpdateConferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);

        btnContestCreate= findViewById(R.id.btn_contestCreate);
        btnConferencesCreate=findViewById(R.id.btn_ConferencesCreate);
        btnDeleteContest=findViewById(R.id.btnContestDelete);

        btnContestCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_actions.this,Activity_ContestCreate.class));
            }
        });

        btnConferencesCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_actions.this,Activity_ConferencesCreate.class));
            }
        });

        btnDeleteContest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_actions.this,Activity_ContestDelete.class));
            }
        });



             }



}
