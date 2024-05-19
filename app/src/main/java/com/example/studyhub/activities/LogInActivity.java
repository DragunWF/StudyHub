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

import com.example.studyhub.LandingPageActivity;
import com.example.studyhub.R;
import com.example.studyhub.data.DatabaseHelper;
import com.example.studyhub.data.SessionData;
import com.example.studyhub.data.User;
import com.example.studyhub.utils.Utils;

import java.util.List;

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

        setButtons();
    }

    private void setButtons() {
        loginBtn = findViewById(R.id.logInBtn);
        registerTextBtn = findViewById(R.id.notRegisteredText);

        loginBtn.setOnClickListener(v -> {
            if (isInputValid() && logInUser()) {
                startActivity(new Intent(LogInActivity.this, DashboardActivity.class));
            }
        });
        registerTextBtn.setOnClickListener(v -> {
            startActivity(new Intent(LogInActivity.this, LandingPageActivity.class));
        });
    }

    private boolean logInUser() {
        try {
            List<User> users = new DatabaseHelper(this).getUsers();
            String usernameStr = Utils.getString(username), passwordStr = Utils.getString(password);
            for (User user : users) {
                if (user.getUsername().equals(usernameStr) && user.getPassword().equals(passwordStr)) {
                    SessionData.setCurrentUser(user);
                    return true;
                }
            }
            toast("Invalid username or password, please make sure you typed in the correct credentials!");
        } catch (Exception error) {
            toast("Something unexpected went wrong while trying to log in!");
        }
        return false;
    }

    private boolean isInputValid() {
        if (Utils.isEmpty(username)) {
            toast("Username cannot be empty!");
            return false;
        }
        if (Utils.isEmpty(password)) {
            toast("Password cannot be empty!");
            return false;
        }
        return true;
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}