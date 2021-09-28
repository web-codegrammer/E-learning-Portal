package com.amdocs.project.model;

public class Course_Enroll {
	private int user_ID;
	private int course_ID;
	
	private Course_Enroll() {
		
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public int getCourse_ID() {
		return course_ID;
	}

	public void setCourse_ID(int course_ID) {
		this.course_ID = course_ID;
	}

	public Course_Enroll(int user_ID, int course_ID) {
		super();
		this.user_ID = user_ID;
		this.course_ID = course_ID;
	}
	
	

}
