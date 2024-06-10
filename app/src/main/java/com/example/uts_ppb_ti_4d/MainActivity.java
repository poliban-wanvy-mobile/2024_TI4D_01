package com.example.uts_ppb_ti_4d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;

    // Replace these with your desired credentials (for demonstration purposes)
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = findViewById(R.id.etUsername);
        passwordField = findViewById(R.id.etPassword);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                if (isValidLogin(username, password)) {
                    // Login successful, navigate to MenuActivity
                    Intent intent = new Intent(MainActivity.this, ActivityMenu.class);
                    startActivity(intent);
                    finish(); // Close LoginActivity
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidLogin(String username, String password) {
        // In a real app, you would validate credentials against a backend service or secure storage
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
