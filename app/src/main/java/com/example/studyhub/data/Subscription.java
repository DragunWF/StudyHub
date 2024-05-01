package com.example.studyhub.data;

public class Subscription {
    private int subscriptionID;
    private String name;
    private String description;

    public Subscription(int subscriptionID, String name, String description) {
        this.subscriptionID = subscriptionID;
        this.name = name;
        this.description = description;
    }

    public Subscription() {

    }

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
