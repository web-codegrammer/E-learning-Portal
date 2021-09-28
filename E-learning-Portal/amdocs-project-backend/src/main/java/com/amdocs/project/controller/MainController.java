package com.amdocs.project.controller;

import com.amdocs.project.dao.ContactDAO;
import com.amdocs.project.dao.CourseDAO;
import com.amdocs.project.dao.FeedbackDAO;
import com.amdocs.project.dao.UserDAO;
import com.amdocs.project.dao.impl.ContactDAOIMPL;
import com.amdocs.project.dao.impl.CourseDAOIMPL;
import com.amdocs.project.dao.impl.FeedbackDAOIMPL;
import com.amdocs.project.dao.impl.UserDAOIMPL;
import com.amdocs.project.model.Contact;
import com.amdocs.project.model.Course;
import com.amdocs.project.model.Feedback;
import com.amdocs.project.model.User;

import java.sql.Date;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        CourseDAO dao=new CourseDAOIMPL();
        List<Course>list=dao.display();
    }
}
