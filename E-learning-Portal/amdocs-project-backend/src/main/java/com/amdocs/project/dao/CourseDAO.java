package com.amdocs.project.dao;


import java.util.List;

import com.amdocs.project.model.Course;

public interface CourseDAO {
    boolean create();
    List<Course> display();
    Course display(int id);
    boolean saveCourse(Course course);
    boolean delete(int courseid);
}
