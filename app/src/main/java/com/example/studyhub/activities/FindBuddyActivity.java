package com.example.studyhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.R;

public class FindBuddyActivity extends AppCompatActivity {
    private Button homeBtn;
    private ImageView nextBtn;
    private ImageView prevBtn;
    private ImageView addBuddyBtn;

    private TextView usernameHeader;
    private TextView description;
    private TextView username;
    private TextView fullName;

    private TextView course;
    private TextView accType;
    private TextView email;
    private TextView mobileNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_buddy);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usernameHeader = findViewById(R.id.findBuddyUsernameHeader);
        description = findViewById(R.id.outputFindBuddyProfileDesc);
        username = findViewById(R.id.outputFindBuddyUsername);
        fullName = findViewById(R.id.outputFindBuddyFullName);

        course = findViewById(R.id.outputFindBuddyCourse);
        accType = findViewById(R.id.outputFindBuddyAccType);
        email = findViewById(R.id.outputFindBuddyEmail);
        mobileNumber = findViewById(R.id.outputFindBuddyMobileNo);

        setButtons();
    }

    private void setButtons() {
        homeBtn = findViewById(R.id.findBuddyHomeBtn);
        nextBtn = findViewById(R.id.findBuddyNextBtn);
        prevBtn = findViewById(R.id.findBuddyPrevBtn);
        addBuddyBtn = findViewById(R.id.findBuddyAddBtn);

        homeBtn.setOnClickListener(v -> {
            startActivity(new Intent(FindBuddyActivity.this, DashboardActivity.class));
        });
        nextBtn.setOnClickListener(v -> {
            // TODO: Implement next selection
        });
        prevBtn.setOnClickListener(v -> {
            // TODO: Implement previous selection
        });
        addBuddyBtn.setOnClickListener(v -> {
            // TODO: Implement add buddy functionality
        });
    }
}