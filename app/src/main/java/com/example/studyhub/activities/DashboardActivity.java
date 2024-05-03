package com.example.studyhub.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyhub.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private ImageView profileIcon;
    private SearchView searchBar;

    private Spinner userTypeSpinner;
    private List<String> userTypeChoices = Arrays.asList("Student", "Tutor");

    private Spinner courseSpinner;
    private List<String> courseChoices = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private RecyclerView.Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        profileIcon = findViewById(R.id.profileIconDashboard);
        searchBar = findViewById(R.id.searchBarDashboard);

        profileIcon.setOnClickListener(v -> {
            // startActivity(DashboardActivity.this, ProfileActivity.class);
        });

        setRecyclerView();
        setSpinners();
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewDashboard);
        recyclerView.setHasFixedSize(true);

        recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        // recyclerAdapter =
    }

    private void setSpinners() {
        userTypeSpinner = findViewById(R.id.userTypeSpinner);
        courseSpinner = findViewById(R.id.courseSpinner);
    }
}