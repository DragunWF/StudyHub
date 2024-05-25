package com.example.studyhub.data;

public class Request {
    private int requestID;
    private int senderID;
    private int receiverID;

    public Request(int requestID, int senderID, int receiverID) {
        this.requestID = requestID;
        this.senderID = senderID;
        this.receiverID = receiverID;
    }

    public int getRequestID() {
        return requestID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }
}
