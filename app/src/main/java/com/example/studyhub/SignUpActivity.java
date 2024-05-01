package com.example.studyhub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.utils.Utils;

public class SignUpActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;

    private EditText firstName;
    private EditText lastName;

    private EditText course;
    private EditText email;
    private EditText mobileNumber;

    private RadioButton studentBtn;
    private RadioButton tutorBtn;

    private Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signupbase), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.signUpInputUsername);
        password = findViewById(R.id.signUpInputPassword);

        firstName = findViewById(R.id.signUpInputFirstName);
        lastName = findViewById(R.id.signUpInputLastName);

        course = findViewById(R.id.signUpInputCourse);
        email = findViewById(R.id.signUpInputEmail);
        mobileNumber = findViewById(R.id.signUpInputMobileNo);

        studentBtn = findViewById(R.id.rBtnStudent);
        tutorBtn = findViewById(R.id.rBtnTutor);
        signUpBtn = findViewById(R.id.signUpBtn);

        signUpBtn.setOnClickListener(v -> {
            if (isInputValid()) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });
    }

    private boolean isInputValid() {
        final int PASSWORD_CHAR_LIMIT = 8;

        if (Utils.getString(username).isEmpty()) {
            toast("Username cannot be empty!");
            return false;
        }
        if (Utils.getString(password).length() < PASSWORD_CHAR_LIMIT) {
            toast(String.format("Password must at least be %s characters", PASSWORD_CHAR_LIMIT));
            return false;
        }
        if (Utils.getString(firstName).isEmpty()) {
            toast("First name cannot be empty!");
            return false;
        }
        if (Utils.getString(lastName).isEmpty()) {
            toast("Last name cannot be empty");
            return false;
        }
        if (Utils.getString(course).isEmpty()) {
            toast("Course cannot be empty!");
            return false;
        }
        if (Utils.getString(email).isEmpty()) {
            toast("Email cannot be empty!");
            return false;
        }
        if (Utils.getString(mobileNumber).isEmpty()) {
            toast("Mobile Number cannot be empty!");
            return false;
        }
        if (!studentBtn.isChecked() && !tutorBtn.isChecked()) {
            toast("Please select an account type! Either Student or Tutor.")
            return false;
        }

        return true;
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}