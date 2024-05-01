package com.example.studyhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.MainActivity;
import com.example.studyhub.R;
import com.example.studyhub.utils.Utils;

public class LogInActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;

    private Button loginBtn;
    private TextView registerTextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginbase), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.inputUsername);
        password = findViewById(R.id.inputPassword);
        
        loginBtn = findViewById(R.id.logInBtn);
        registerTextBtn = findViewById(R.id.notRegisteredText);

        loginBtn.setOnClickListener(v -> {
            if (isInputValid()) {
                startActivity(new Intent(LogInActivity.this, MainActivity.class));
            }
        });
        registerTextBtn.setOnClickListener(v -> {
            startActivity(new Intent(LogInActivity.this, MainActivity.class));
        });
    }

    private boolean isInputValid() {
        if (Utils.getString(username).isEmpty()) {
            toast("Username cannot be empty!");
            return false;
        }
        if (Utils.getString(password).isEmpty()) {
            toast("Password cannot be empty!");
            return false;
        }
        return true;
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}