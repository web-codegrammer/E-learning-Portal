package com.amdocs.project.model;

public class Admin {
    private String name;
    private String email;
    private String password;
    private int adminID;

    private Admin(){}

    public Admin(String name, String email, String password, int admin_ID) {
        this.name = name;
        this.email = email;
        this.password = password;
        adminID = admin_ID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
}
