package com.example.studyhub.activities;

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

public class EditProfileActivity extends AppCompatActivity {
    private ImageView backBtn;
    private Button submitBtn;

    private TextView username;
    private TextView password;
    private TextView firstName;
    private TextView lastName;


    private TextView course;
    private TextView email;
    private TextView mobileNumber;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.inputEditProfileUsername);
        firstName = findViewById(R.id.inputEditProfileFirstname);
        lastName = findViewById(R.id.inputEditProfileLastname);

        course = findViewById(R.id.inputEditProfileCourse);
        email = findViewById(R.id.inputEditProfileEmail);
        mobileNumber = findViewById(R.id.inputEditProfileMobileNo);
        description = findViewById(R.id.inputEditProfileDesc);

        setButtons();
    }

    private void setButtons() {
        backBtn = findViewById(R.id.editProfileBackBtn);
        submitBtn = findViewById(R.id.editProfileSubmitBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        submitBtn.setOnClickListener(v -> {
            // TODO: Implement account information changes
        });
    }

    private void isInputValid() {

    }
}