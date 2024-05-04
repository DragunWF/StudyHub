package com.example.studyhub.activities;

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

public class ProfileActivity extends AppCompatActivity {
    private ImageView backBtn;
    private ImageView viewBuddyListBtn;
    private ImageView editProfileBtn;
    private ImageView subscriptionBtn;

    private TextView description;
    private TextView username;
    private TextView fullName;

    private TextView course;
    private TextView accType;
    private TextView email;
    private TextView mobileNumber;

    private TextView buddyCount;
    private TextView accTier;

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
    }

    private void setButtons() {
        backBtn = findViewById(R.id.profileBackBtn);
        viewBuddyListBtn = findViewById(R.id.viewBuddyListBtn);
        editProfileBtn = findViewById(R.id.editProfileBtn);
        subscriptionBtn = findViewById(R.id.subscriptionBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        viewBuddyListBtn.setOnClickListener(v -> {
            // startActivity(new Intent(ProfileActivity.this, BuddyListActivity.class));
        });
        editProfileBtn.setOnClickListener(v -> {
            // startActivity(new Intent(ProfileActivity.this, AccountEditActivity.class));
        });
        subscriptionBtn.setOnClickListener(v -> {
           // startActivity(new Intent(ProfileActivity.this, SubscriptionActivity.class));
        });
    }
}