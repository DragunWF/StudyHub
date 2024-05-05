package com.example.studyhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyhub.activities.LogInActivity;
import com.example.studyhub.activities.SignUpActivity;

public class LandingPageActivity extends AppCompatActivity {
    private Button loginBtn;
    private Button registerBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_landing_page);
        loginBtn = findViewById(R.id.landingLogInBtn);
        registerBtn = findViewById(R.id.landingSignUpBtn);

        loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(LandingPageActivity.this, LogInActivity.class));
        });
        registerBtn.setOnClickListener(v -> {
            startActivity(new Intent(LandingPageActivity.this, SignUpActivity.class));
        });
    }
}