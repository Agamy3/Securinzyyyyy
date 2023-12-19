package com.example.securinzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    DBHelper DB;
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView signUpTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB = new DBHelper(this);

        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);

        signUpTextView = findViewById(R.id.textView);
        signUpTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);

            }

        });

        Button loginButton = findViewById(R.id.button);
        DB= new DBHelper(MainActivity.this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (email.equals("")||password.equals("")){
                    Toast.makeText(MainActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean checkemailpassword = DB.checkemailpassword(email,password);
                    if (checkemailpassword==true){
                        Toast.makeText(MainActivity.this,"Sign in successfully",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, SERVICES.class);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Invalid E-mail or Password ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });}

            }

