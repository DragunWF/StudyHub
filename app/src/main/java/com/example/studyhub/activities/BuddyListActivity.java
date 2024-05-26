package com.example.studyhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyhub.R;
import com.example.studyhub.data.User;
import com.example.studyhub.utils.RecyclerUsers;

import java.util.ArrayList;
import java.util.List;

public class BuddyListActivity extends AppCompatActivity {
    private ImageView backBtn;
    private Button homeBtn;

    private RecyclerView buddyRecycler;
    private RecyclerView.Adapter adapter;

    private List<User> buddies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buddy_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backBtn = findViewById(R.id.buddyListBackBtn);
        homeBtn = findViewById(R.id.buddyListHomeBtn);

        backBtn.setOnClickListener(v -> finish());
        homeBtn.setOnClickListener(v -> {
            startActivity(new Intent(BuddyListActivity.this, DashboardActivity.class));
        });

        setBuddiesData();
        setRecyclerView();
    }

    private void setBuddiesData() {
        // TODO: Implement buddy data grabbing
    }

    private void setRecyclerView() {
        buddyRecycler = findViewById(R.id.buddyListRecyclerView);

        buddyRecycler.setHasFixedSize(true);
        buddyRecycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerUsers(this, buddies);
        buddyRecycler.setAdapter(adapter);
    }
}