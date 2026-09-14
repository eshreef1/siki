package com.eshreef.help.model;

public class ChatMessage {
    private String text;
    private String senderName;
    private String senderUid;
    private long timestamp;

    public ChatMessage() {
    }

    public ChatMessage(String text, String senderName, String senderUid, long timestamp) {
        this.text = text;
        this.senderName = senderName;
        this.senderUid = senderUid;
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderUid() {
        return senderUid;
    }

    public void setSenderUid(String senderUid) {
        this.senderUid = senderUid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
