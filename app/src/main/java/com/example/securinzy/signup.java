package com.example.securinzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button back ;
        Button sign_up;
       sign_up=findViewById(R.id.button);
       sign_up.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent( signup.this , SERVICES.class);
startActivity(i);
           }
       });
       back=findViewById(R.id.button_back);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent ii = new Intent(signup.this, MainActivity.class);
               startActivity(ii);
           }
       });
    }
}