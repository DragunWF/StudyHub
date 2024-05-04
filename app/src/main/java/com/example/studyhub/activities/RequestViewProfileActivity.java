package com.example.studyhub.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.R;
import com.example.studyhub.data.User;

public class RequestViewProfileActivity extends AppCompatActivity {
    private ImageView backBtn;
    private ImageView acceptBtn;
    private ImageView rejectBtn;

    private TextView usernameHeader;
    private TextView description;

    private TextView username;
    private TextView fullName;

    private TextView course;
    private TextView accType;
    private TextView email;
    private TextView mobileNumber;

    private User viewedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_view_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setButtons() {
        backBtn = findViewById(R.id.requestViewProfileBackBtn);
        acceptBtn = findViewById(R.id.acceptRequestBtn);
        rejectBtn = findViewById(R.id.rejectRequestBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        acceptBtn.setOnClickListener(v -> {
            // TODO: Implement accept request functionality
        });
        rejectBtn.setOnClickListener(v -> {
            // TODO: Implement reject request functionality
        });
    }

    @SuppressLint("SetTextI18n")
    private void setInfo() {
        usernameHeader.setText(viewedUser.getUsername());
        description.setText(viewedUser.getDescription());

        username.setText("Username: " + viewedUser.getUsername());
        fullName.setText("Full Name: " + viewedUser.getFullName());

        course.setText("Course: " + viewedUser.getCourse());
        accType.setText("Acc. Type: " + viewedUser.getUserType());
        email.setText("Email: " + viewedUser.getEmail());
        mobileNumber.setText("Mobile No: " + viewedUser.getMobileNumber());
    }
}