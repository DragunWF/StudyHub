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

public class RequestListActivity extends AppCompatActivity {
    private ImageView backBtn;
    private Button homeBtn;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private RecyclerView.Adapter recyclerAdapter;

    private List<User> userRequests = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // TODO: Implement data retrieval to fill userList

        setRecyclerView();
        setButtons();
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.requestListRecyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerAdapter = new RecyclerUsers(this, userRequests);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void setButtons() {
        backBtn = findViewById(R.id.requestListBackBtn);
        homeBtn = findViewById(R.id.requestListHomeBtn);

        backBtn.setOnClickListener(v -> finish());
        homeBtn.setOnClickListener(v -> {
            startActivity(new Intent(RequestListActivity.this, DashboardActivity.class));
        });
    }
}