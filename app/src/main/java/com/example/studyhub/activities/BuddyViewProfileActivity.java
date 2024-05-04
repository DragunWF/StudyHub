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

public class BuddyViewProfileActivity extends AppCompatActivity {
    private ImageView backBtn;
    private TextView buddyCount;

    private TextView usernameHeader;
    private TextView description;

    private TextView username;
    private TextView fullName;

    private TextView course;
    private TextView accType;
    private TextView email;
    private TextView mobileNumber;

    private User buddy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buddy_view_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // TODO: Implement buddy data retrieval

        backBtn = findViewById(R.id.buddyViewProfileBackBtn);
        buddyCount = findViewById(R.id.outputBuddyViewProfileSBC);

        usernameHeader = findViewById(R.id.outputBuddyViewProfileHeaderUsername);
        description = findViewById(R.id.outputBuddyViewProfileDesc);

        username = findViewById(R.id.outputBuddyViewProfileUsername);
        fullName = findViewById(R.id.outputBuddyViewProfileFullname);

        course = findViewById(R.id.outputBuddyViewProfileCourse);
        accType = findViewById(R.id.outputBuddyViewProfileAccType);
        email = findViewById(R.id.outputBuddyViewProfileEmail);
        mobileNumber = findViewById(R.id.outputBuddyViewProfileMobileNo);

        backBtn.setOnClickListener(v -> {
            finish();
        });
    }

    @SuppressLint("SetTextI18n")
    private void setInfo() {
        usernameHeader.setText(buddy.getUsername());
        description.setText(buddy.getDescription());

        username.setText("Username: " + buddy.getUsername());
        fullName.setText("Full Name: " + buddy.getFullName());

        course.setText("Course: " + buddy.getCourse());
        accType.setText("Acc. Type: " + buddy.getUserType());
        email.setText("Email: " + buddy.getEmail());
        mobileNumber.setText("Mobile No: " + buddy.getMobileNumber());

        // TODO: Implement buddy counting
    }
}