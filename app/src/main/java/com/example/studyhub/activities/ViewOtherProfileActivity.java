package com.example.studyhub.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.R;

public class ViewOtherProfileActivity extends AppCompatActivity {
    private ImageView backBtn;

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
        setContentView(R.layout.activity_view_other_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usernameHeader = findViewById(R.id.viewOthersUsernameHeader);
        description = findViewById(R.id.viewOthersProfileDesc);

        username = findViewById(R.id.outputViewOthersUsername);
        fullName = findViewById(R.id.outputFindBuddyFullName);

        course = findViewById(R.id.outputViewOthersCourse);
        accType = findViewById(R.id.outputViewOthersAccType);
        email = findViewById(R.id.outputViewOthersEmail);
        mobileNumber = findViewById(R.id.outputViewOthersMobileNo);

        backBtn = findViewById(R.id.viewOthersBackBtn);
        backBtn.setOnClickListener(v -> {
            finish();
        });
    }
}