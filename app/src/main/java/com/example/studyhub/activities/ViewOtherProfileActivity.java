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
import com.example.studyhub.data.DatabaseHelper;
import com.example.studyhub.data.User;

public class ViewOtherProfileActivity extends AppCompatActivity {
    private ImageView backBtn;
    private ImageView addBuddyBtn;

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
        setContentView(R.layout.activity_view_other_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewedUser = new DatabaseHelper(this).getUserById(getIntent().getIntExtra("id", 1));

        usernameHeader = findViewById(R.id.viewOthersUsernameHeader);
        description = findViewById(R.id.outputViewOthersProfileDesc);

        username = findViewById(R.id.outputViewOthersUsername);
        fullName = findViewById(R.id.outputViewOthersFullname);

        course = findViewById(R.id.outputViewOthersCourse);
        accType = findViewById(R.id.outputViewOthersAccType);
        email = findViewById(R.id.outputViewOthersEmail);
        mobileNumber = findViewById(R.id.outputViewOthersMobileNo);

        setButtons();
        setInfo();
    }

    private void setButtons() {
        backBtn = findViewById(R.id.viewOthersBackBtn);
        addBuddyBtn = findViewById(R.id.viewOthersAddBuddyBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        addBuddyBtn.setOnClickListener(v -> {
           // TODO: Implement friend requests
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

        // TODO: Implement buddy counting
    }
}