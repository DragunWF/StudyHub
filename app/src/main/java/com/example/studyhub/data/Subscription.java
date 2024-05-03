package com.example.studyhub.data;

public class Subscription {
    private int subscriptionId;
    private String name;
    private String description;

    public Subscription(int subscriptionId, String name, String description) {
        this.subscriptionId = subscriptionId;
        this.name = name;
        this.description = description;
    }

    public Subscription() {

    }

    public int getSubscriptionId() {
        return subscriptionId;
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
