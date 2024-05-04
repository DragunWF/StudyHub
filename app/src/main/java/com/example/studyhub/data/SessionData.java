package com.example.studyhub.data;

public class SessionData {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }
}
