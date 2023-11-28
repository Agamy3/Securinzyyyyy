package com.example.securinzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SERVICES extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Button swtest;
        Button network;
        Button booking;
        Button pentest ;
        network = findViewById(R.id.button_network);
        pentest = findViewById(R.id.button_pentest);
        swtest = findViewById(R.id.button_swtest);
        booking = findViewById(R.id.button_booking);

        pentest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SERVICES.this , pentestActivity.class);
                startActivity(i);
            }
        });
        network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(SERVICES.this , network.class);
                startActivity(ii);
            }
        });
        swtest=findViewById(R.id.button_swtest);
        swtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii = new Intent(SERVICES.this, softwareTesting.class);
                startActivity(iii);
            }
        });


    }
}