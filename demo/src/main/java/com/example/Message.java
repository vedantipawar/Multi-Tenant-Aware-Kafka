package com.example;

public class Message {
    public String tenant_id;
    public String data;

    // Constructor with parameters
    public Message(String tenant_id, String data) {
        this.tenant_id = tenant_id;
        this.data = data;
    }

    // No-argument constructor needed for deserialization
    public Message() {
    }
}
