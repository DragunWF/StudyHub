package com.example.studyhub.data;

import android.widget.EditText;

import java.util.HashMap;

public class SessionData {
    private static User currentUser;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static UserUpdateInfo updateCurrentUserInfo(HashMap<String, EditText> info) {
        UserUpdateInfo updateInfo = new UserUpdateInfo();
        for (String key : info.keySet()) {
            String value = String.valueOf(info.get(key).getText());
            if (value.isEmpty()) {
                continue;
            }
            switch (key) {
                case "username":
                    updateInfo.setUsername(value);
                    currentUser.setUsername(value);
                    break;
                case "password":
                    updateInfo.setPassword(value);
                    currentUser.setPassword(value);
                    break;
                case "firstName":
                    updateInfo.setFirstName(value);
                    currentUser.setFirstName(value);
                    break;
                case "lastName":
                    updateInfo.setLastName(value);
                    currentUser.setLastName(value);
                    break;
                case "course":
                    updateInfo.setCourse(value);
                    currentUser.setCourse(value);
                    break;
                case "email":
                    updateInfo.setEmail(value);
                    currentUser.setEmail(value);
                    break;
                case "mobileNumber":
                    updateInfo.setMobileNumber(value);
                    currentUser.setMobileNumber(value);
                    break;
                case "description":
                    updateInfo.setDescription(value);
                    currentUser.setDescription(value);
                    break;
            }
        }
        return updateInfo;
    }
}
