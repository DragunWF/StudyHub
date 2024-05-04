package com.example.studyhub.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyhub.data.User;

import java.util.HashMap;

public class Utils {
    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static String getString(EditText text) {
        return String.valueOf(text.getText());
    }

    public static boolean isEmpty(EditText text) {
        return Utils.getString(text).isEmpty();
    }

    @SuppressLint("SetTextI18n")
    public static void setProfileInfo(User user, HashMap<String, TextView> infoMap) {
        try {
            infoMap.get("description").setText(user.getDescription());
            infoMap.get("username").setText("Username: " + user.getUsername());
            infoMap.get("fullName").setText("Full Name: " + user.getFullName());
            infoMap.get("course").setText("Course: " + user.getCourse());
            infoMap.get("userType").setText("Acc. Type: " + user.getUserType());
            infoMap.get("email").setText("Email: " + user.getEmail());
            infoMap.get("mobileNumber").setText("Mobile No: " + user.getMobileNumber());
        } catch (NullPointerException error) {
            infoMap.get("description").setText("Error trying to retrieve user data!");
            for (String key : infoMap.keySet()) {
                infoMap.get(key).setText("Null");
            }
        }
    }
}
