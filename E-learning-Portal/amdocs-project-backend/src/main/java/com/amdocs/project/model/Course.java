package com.amdocs.project.model;

public class Course {
    private String courseName;
    private int courseID;
    private String courseResource;
    private String courseDesc;
    private int courseFee;

    private Course(){}

    public Course(String courseName, int course_ID, String course_Resource, String course_Desc, int course_Fee) {
        this.courseName = courseName;
        courseID = course_ID;
        courseResource = course_Resource;
        courseDesc = course_Desc;
        courseFee = course_Fee;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseResource() {
        return courseResource;
    }

    public void setCourseResource(String courseResource) {
        this.courseResource = courseResource;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public int getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(int courseFee) {
        this.courseFee = courseFee;
    }
}
