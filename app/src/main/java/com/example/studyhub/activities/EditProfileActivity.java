package com.example.studyhub.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.R;
import com.example.studyhub.data.DatabaseHelper;
import com.example.studyhub.data.SessionData;
import com.example.studyhub.data.UserUpdateInfo;
import com.example.studyhub.utils.Utils;

import java.util.HashMap;

public class EditProfileActivity extends AppCompatActivity {
    private ImageView backBtn;
    private Button submitBtn;
    private HashMap<String, EditText> info = new HashMap<>();

    @SuppressLint("FindViewByIdCast")
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

        info.put("username", findViewById(R.id.inputEditProfileUsername));
        info.put("password", null); // TODO: add a password update field
        info.put("firstName", findViewById(R.id.inputEditProfileFirstname));
        info.put("lastName", findViewById(R.id.inputEditProfileLastname));

        info.put("course", findViewById(R.id.inputEditProfileCourse));
        info.put("email", findViewById(R.id.inputEditProfileEmail));
        info.put("mobileNumber", findViewById(R.id.inputEditProfileMobileNo));
        info.put("description", findViewById(R.id.inputEditProfileDesc));

        setButtons();
    }

    private void setButtons() {
        backBtn = findViewById(R.id.editProfileBackBtn);
        submitBtn = findViewById(R.id.editProfileSubmitBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        submitBtn.setOnClickListener(v -> {
            if (!isInputValid()) {
                return;
            }

            new DatabaseHelper(EditProfileActivity.this).updateUserInfo(SessionData.updateCurrentUserInfo(info));
            startActivity(new Intent(EditProfileActivity.this, ProfileActivity.class));
        });
    }

    private boolean isInputValid() {
//        if (Utils.getString(info.get("password")).isEmpty()) {
//            return true;
//        }
//        return Utils.isValidPassword(Utils.getString(info.get("password")));
        return true;
    }

    private void toast(String message) {
        Utils.toast(this, message);
    }
}