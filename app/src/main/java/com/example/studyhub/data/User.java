package com.example.studyhub.data;

import com.example.studyhub.utils.Utils;

public class User {
    private int userId;
    private String username;
    private String password;

    private String firstName;
    private String lastName;

    private String course;
    private String email;
    private String mobileNumber;
    private String userType;

    private String description;
    private String friends;
    private int subscriptionId;

    public User(String username, String fullName, String course, String description) throws Exception {
        // Constructor to use when creating dummy data
        String[] name = fullName.split(" ");
        if (name.length < 2) {
            throw new Exception("Full name must have two words separated with a space!");
        }
        if (username.length() > 10) {
            throw new Exception("Username cannot have more than 10 characters!");
        }

        // Manual data
        this.username = username;
        this.firstName = name[0];
        this.lastName = name[1];
        this.course = course;
        this.description = description;

        // Automatic dummy data
        this.password = "password";
        this.mobileNumber = Utils.generateRandomPhoneNumber();
        this.email = String.format("%s%s@gmail.com", name[0].toLowerCase(), name[1].toLowerCase());
        this.userType = ((int)Math.floor(Math.random() * 10)) <= 1 ? "tutor" : "student";
        this.subscriptionId = 1;
    }

    public User(String username, String password, String firstName, String lastName, String course, String email, String mobileNumber, String userType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userType = userType;
        this.subscriptionId = 1;
    }

    public User(String username, String password, String firstName, String lastName, String course, String email, String mobileNumber, String userType, String description, String friends, int subscriptionId) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userType = userType;
        this.description = description;
        this.friends = friends;
        this.subscriptionId = subscriptionId;
    }

    public User(int userId, String username, String password, String firstName, String lastName, String course, String email, String mobileNumber, String userType, String description, String friends, int subscriptionId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userType = userType;
        this.description = description;
        this.friends = friends;
        this.subscriptionId = subscriptionId;
    }

    // Dynamic Getters
    public String getFullName() {
        return String.format("%s %s", getFirstName(), getLastName());
    }

    public int getBuddyCount() {
        if (friends.isEmpty()) {
            return 0;
        }
        return friends.split(",").length;
    }

    // Setters and Getters
    public int getId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
