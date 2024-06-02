package com.example.studyhub.activities;

import android.annotation.SuppressLint;
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
import com.example.studyhub.data.DatabaseHelper;
import com.example.studyhub.data.SessionData;
import com.example.studyhub.data.User;
import com.example.studyhub.utils.Utils;

import java.util.ArrayList;
import java.util.List;

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

    private List<User> selectedUsers = new ArrayList<>();
    private int selectedUserIndex = 0;
    private final int SELECTED_USERS_LIMIT = 15;

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

        setSelectedUsers();
        setButtons();
        setUserData();
    }

    private void setSelectedUsers() {
        List<User> users = new DatabaseHelper(this).getUsers();
        List<Integer> availableUserIds = new ArrayList<>();
        List<Integer> selectedUserIds = new ArrayList<>();

        for (User user : users) {
            if (user.getId() != SessionData.getCurrentUser().getId()) {
                availableUserIds.add(user.getId());
            }
        }

        while (selectedUserIds.size() < SELECTED_USERS_LIMIT) {
            int randomIndex = (int)Math.floor(Math.random() * availableUserIds.size());
            int selectedId = availableUserIds.get(randomIndex);
            selectedUserIds.add(selectedId);
            availableUserIds.remove(randomIndex);
        }

        for (User user : users) {
            if (selectedUserIds.contains(user.getId())) {
                selectedUsers.add(user);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void setUserData() {
        User user = selectedUsers.get(selectedUserIndex);

        usernameHeader.setText(user.getUsername());
        description.setText(user.getDescription());
        username.setText("Username: " + user.getUsername());
        fullName.setText("Full Name: " + user.getFullName());

        course.setText("Course: " + user.getCourse());
        accType.setText("Acc. Type: " + user.getUserType());
        email.setText("Email: " + user.getEmail());
        mobileNumber.setText("Mobile No: " + user.getMobileNumber());
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
            selectedUserIndex++;
            if (selectedUserIndex >= selectedUsers.size()) {
                selectedUserIndex = 0;
            }
            setUserData();
        });
        prevBtn.setOnClickListener(v -> {
            selectedUserIndex--;
            if (selectedUserIndex < 0) {
                selectedUserIndex = selectedUsers.size() - 1;
            }
            setUserData();
        });
        addBuddyBtn.setOnClickListener(v -> {
            Utils.addBuddy(FindBuddyActivity.this, selectedUsers.get(selectedUserIndex).getId());
        });
    }
}