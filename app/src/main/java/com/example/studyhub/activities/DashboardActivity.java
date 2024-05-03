package com.example.studyhub.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import com.example.studyhub.data.User;
import com.example.studyhub.utils.RecyclerDashboardUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private ImageView profileIcon;
    private SearchView searchBar;
    private Button findStudyBuddyBtn;

    private Spinner userTypeSpinner;
    private final List<String> userTypeChoices = Arrays.asList("Any", "Student", "Tutor");

    private Spinner courseSpinner;
    private final List<String> courseChoices = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private RecyclerView.Adapter recyclerAdapter;

    private final List<User> userList = new ArrayList<>();
    private List<User> currentUserList = new ArrayList<>();

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
        findStudyBuddyBtn = findViewById(R.id.findBuddyBtn);

        findStudyBuddyBtn.setOnClickListener(v -> {
            // startActivity(new Intent(DashboardActivity.this, FindBuddyActivity.class));
        });
        profileIcon.setOnClickListener(v -> {
            // startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
        });

        setRecyclerView();
        setSpinners();
    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewDashboard);
        recyclerView.setHasFixedSize(true);

        recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerAdapter = new RecyclerDashboardUsers(this, userList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void setSpinners() {
        userTypeSpinner = findViewById(R.id.userTypeSpinner);
        courseSpinner = findViewById(R.id.courseSpinner);

        ArrayAdapter<String> userTypeAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, userTypeChoices
        );
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, courseChoices
        );

        userTypeAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        userTypeSpinner.setAdapter(userTypeAdapter);
        courseAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        courseSpinner.setAdapter(courseAdapter);

        userTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
