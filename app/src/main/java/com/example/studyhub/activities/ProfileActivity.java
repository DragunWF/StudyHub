package com.example.studyhub.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.R;
import com.example.studyhub.data.SessionData;
import com.example.studyhub.data.User;

public class ProfileActivity extends AppCompatActivity {
    private ImageView backBtn;
    private ImageView viewBuddyListBtn;
    private ImageView editProfileBtn;
    private ImageView subscriptionBtn;
    private ImageView requestsBtn;

    private TextView description;
    private TextView username;
    private TextView fullName;

    private TextView course;
    private TextView accType;
    private TextView email;
    private TextView mobileNumber;

    private TextView buddyCount;
    private TextView accTier;

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        currentUser = SessionData.getCurrentUser();

        description = findViewById(R.id.outputProfileDesc);
        username = findViewById(R.id.outputProfileDetailsUsername);
        fullName = findViewById(R.id.outputProfileDetailsFullName);

        course = findViewById(R.id.outputProfileDetailsCourse);
        accType = findViewById(R.id.outputProfileDetailsAccType);
        email = findViewById(R.id.outputProfileDetailsEmail);
        mobileNumber = findViewById(R.id.outputProfileDetailsMobileNo);

        buddyCount = findViewById(R.id.outputProfileBuddyCount);
        accTier = findViewById(R.id.outputProfileAccountTier);

        setButtons();
        setInfo();
    }

    private void setButtons() {
        backBtn = findViewById(R.id.profileBackBtn);
        viewBuddyListBtn = findViewById(R.id.viewBuddyListBtn);
        editProfileBtn = findViewById(R.id.editProfileBtn);
        subscriptionBtn = findViewById(R.id.subscriptionBtn);
        requestsBtn = findViewById(R.id.viewRequestsBtn);

        backBtn.setOnClickListener(v -> finish());
        viewBuddyListBtn.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, BuddyListActivity.class));
        });
        editProfileBtn.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
        });
        subscriptionBtn.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, SubscriptionActivity.class));
        });
        requestsBtn.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, RequestListActivity.class));
        });
    }

    @SuppressLint("SetTextI18n")
    private void setInfo() {
        description.setText(currentUser.getDescription());

        username.setText("Username: " + currentUser.getUsername());
        fullName.setText("Full Name: " + currentUser.getFullName());

        course.setText("Course: " + currentUser.getCourse());
        accType.setText("Acc. Type: " + currentUser.getUserType());
        email.setText("Email: " + currentUser.getEmail());
        mobileNumber.setText("Mobile No: " + currentUser.getMobileNumber());

        // TODO: Implement buddy counting and account tier identification
    }
}