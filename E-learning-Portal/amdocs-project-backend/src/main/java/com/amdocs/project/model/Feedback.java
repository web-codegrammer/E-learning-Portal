package com.amdocs.project.model;

public class Feedback {
    private int userID;
    private String name;
    private String email;
    private String feedback;

    private Feedback(){}

    public Feedback(int user_ID, String name, String email, String feedback) {
        userID = user_ID;
        this.name = name;
        this.email = email;
        this.feedback = feedback;
    }

    public int getUserID() {
    	System.out.println(userID);
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
