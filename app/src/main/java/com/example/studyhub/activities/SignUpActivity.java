package com.example.studyhub.activities;

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

import com.example.studyhub.LandingPageActivity;
import com.example.studyhub.R;
import com.example.studyhub.data.DatabaseHelper;
import com.example.studyhub.data.User;
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

        DatabaseHelper db = new DatabaseHelper(this);

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

        tutorBtn.setOnClickListener(v -> studentBtn.setChecked(false));
        studentBtn.setOnClickListener(v -> tutorBtn.setChecked(false));

        signUpBtn.setOnClickListener(v -> {
            if (isInputValid()) {
                String userType = studentBtn.isChecked() ? "student" : "tutor";
                User createdUser = new User(
                        Utils.getString(username), Utils.getString(password), Utils.getString(firstName),
                        Utils.getString(lastName), Utils.getString(course), Utils.getString(email),
                        Utils.getString(mobileNumber), userType
                );
                db.addUser(createdUser);
                Utils.longToast(SignUpActivity.this, "Details about linking your STI account has been sent to your email!");
                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
            }
        });
    }

    private boolean isInputValid() {
        final int PASSWORD_CHAR_LIMIT = 8;

        // Forgive me father for I have sinned...
        if (Utils.isEmpty(username)) {
            toast("Username cannot be empty!");
            return false;
        }
        if (Utils.getString(password).length() < PASSWORD_CHAR_LIMIT) {
            toast(String.format("Password must at least be %s characters", PASSWORD_CHAR_LIMIT));
            return false;
        }
        if (Utils.isEmpty(firstName)) {
            toast("First name cannot be empty!");
            return false;
        }
        if (Utils.isEmpty(lastName)) {
            toast("Last name cannot be empty");
            return false;
        }
        if (Utils.isEmpty(course)) {
            toast("Course cannot be empty!");
            return false;
        }
        if (Utils.isEmpty(email)) {
            toast("Email cannot be empty!");
            return false;
        }
        if (Utils.isEmpty(mobileNumber)) {
            toast("Mobile Number cannot be empty!");
            return false;
        }
        if (!studentBtn.isChecked() && !tutorBtn.isChecked()) {
            toast("Please select an account type! Either Student or Tutor.");
            return false;
        }

        return true;
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}