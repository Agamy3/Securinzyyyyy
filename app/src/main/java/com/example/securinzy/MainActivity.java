package com.example.securinzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView signUpTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a = emailEditText.getText().toString();
                String b = passwordEditText.getText().toString();
                checkPwInDB(a , b);
                // Get email and password
                // Validate credentials
                // Launch home activity on success
            }
        });}
    private void checkPwInDB(String m, String p) {
        runOnUiThread(() -> {

                    String pw = null;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT Password FROM ClientTable WHERE Email = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, m);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                pw = resultSet.getString("Password");
            }
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (pw != null && pw.equals(p)) {
            runOnUiThread(() -> {
                Intent ii = new Intent(MainActivity.this, SERVICES.class);
                startActivity(ii);
            });
        } else {
            System.out.println("INCORRECT EMAIL OR PASSWORD");
        }
        });

    }
                // You may want to handle the SQL exception here, such as logging the error or notifying the user
            }

