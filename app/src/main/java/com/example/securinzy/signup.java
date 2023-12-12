package com.example.securinzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signup extends AppCompatActivity {

    private EditText editTextFirstName;
    private EditText editTextSecondName;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private EditText editTextphonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextSecondName = findViewById(R.id.editTextSecondName);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextphonenumber = findViewById(R.id.editTextphonenumber);

        Button back = findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(signup.this, MainActivity.class);
                startActivity(ii);
            }
        });

        Button sign_up = findViewById(R.id.button);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editTextFirstName.getText().toString();
                String b = editTextSecondName.getText().toString();
                String c = editTextTextEmailAddress.getText().toString();
                String d = editTextTextPassword.getText().toString();
                String e = editTextphonenumber.getText().toString();
                insertDataIntoDatabase(a, b, c, d, e);
                Intent i = new Intent(signup.this, SERVICES.class);
                startActivity(i);
            }
        });
    }

    private void insertDataIntoDatabase(String firstName, String lastName, String email, String password, String phoneNumber) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO ClientTable (First Name, Last Name, Email, Password, Phone Number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.setString(5, phoneNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // You may want to handle the SQL exception here, such as logging the error or notifying the user
        }
    }
}