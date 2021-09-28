package com.amdocs.project.model;

public class Contact {
    private int userID;
    private String email;
    private String name;
    private long phone;
    private String message;

    private Contact(){}

    public Contact(int user_ID, String email, String name, long phone, String message) {
        userID = user_ID;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.message = message;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
