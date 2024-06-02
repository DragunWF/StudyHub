package com.example.studyhub.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyhub.data.DatabaseHelper;
import com.example.studyhub.data.User;
import com.example.studyhub.data.UserUpdateInfo;

import java.util.HashMap;

public class Utils {
    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static String getString(EditText text) {
        return String.valueOf(text.getText());
    }

    public static boolean isEmpty(EditText text) {
        return Utils.getString(text).isEmpty();
    }

    public static String generateRandomPhoneNumber() {
        StringBuilder output = new StringBuilder();
        output.append("0960");
        // 7 to indicate the remaining numbers for a complete phone number
        // This method assumes all phone numbers come from the Philippines therefore +63 isn't needed
        for (int i = 1; i <= 7; i++) {
            output.append((int)Math.floor(Math.random() * 10));
        }
        return output.toString();
    }

    public static String generateUserValuesQuery(User[] users) {
        StringBuilder query = new StringBuilder();
        query.append("VALUES ");
        for (int i = 0 ; i < users.length; i++) {
            User user = users[i];
            // username, password, firstName, lastName, course
            // email, mobileNumber, userType, description, subscriptionId
            String row = String.format("('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s)",
                    user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getCourse(),
                    user.getEmail(), user.getMobileNumber(), user.getUserType(), user.getDescription(), user.getSubscriptionId());
            if (i + 1 != users.length) {
                row += ", ";
            }
            query.append(row);
        }
        return query.toString();
    }

    public static String getDescription(User user) {
        return user.getDescription() != null ? user.getDescription() : "No description provided...";
    }

    public static void addBuddy(Context context, int receiverId) {
        if (new DatabaseHelper(context).addRequest(receiverId)) {
            Utils.toast(context, "A buddy request has been sent!");
        } else {
            Utils.toast(context, "You've already sent a request to this user!");
        }
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 8; // Password character limit
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
