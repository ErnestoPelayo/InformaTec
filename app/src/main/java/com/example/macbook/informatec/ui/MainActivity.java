package com.example.macbook.informatec.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.macbook.informatec.R;
import com.example.macbook.informatec.activity_actions;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;
    Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2 = (Button) findViewById(R.id.btnEventos);
        btn = (Button) findViewById(R.id.btnConcursos);
        bt3= (Button) findViewById(R.id.btnActions);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityContest.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityConferences.class));
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,activity_actions.class));
            }
        });

    }
}
