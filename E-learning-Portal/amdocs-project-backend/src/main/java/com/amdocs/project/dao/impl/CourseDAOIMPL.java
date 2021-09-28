package com.amdocs.project.dao.impl;

import com.amdocs.project.dao.CourseDAO;
import com.amdocs.project.db.DBUtils;
import com.amdocs.project.db.DataSourceUtil;
import com.amdocs.project.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CourseDAOIMPL implements CourseDAO {
	DataSource dataSource = DataSourceUtil.dataSource();
    @Override
    public boolean create() {
        String query="create table course(course_id int primary key, c_name varchar(100),c_desp varchar(100), c_fees varchar(100),c_resource varchar(100))";
        try{
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(query);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Course> display() {
        String display="select * from course";
        List<Course>list=new ArrayList<>();
        try{
        	//Connection conn = DBUtils.getConn();
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet data=stmt.executeQuery(display);
            while (data.next())
            {
                int c_fee=data.getInt(4);
                int c_ID=data.getInt(1);
                String c_name=data.getNString(2);
                String c_desp=data.getNString(3);
                String c_resource=data.getNString(5);
                Course course=new Course(c_name,c_ID,c_resource,c_desp,c_fee);
                list.add(course);
                System.out.println("Course_ID : "+c_ID+"\tCourse Name : "+c_name+"\tCourse_desp : "+c_desp+"\tCourse_Fees : "+c_fee+"\tCourse Resource : "+c_resource);
            }
            return list;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveCourse(Course course) {
        String insert = "insert into course values(?,?,?,?,?)";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(insert);
            ps.setNString(2,course.getCourseName());
            ps.setInt(1,course.getCourseID());
            ps.setNString(3,course.getCourseDesc());
            ps.setInt(4,course.getCourseFee());
            ps.setNString(5,course.getCourseResource());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int courseid) {
        String query="delete from course where course_id=?";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setInt(1,courseid);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public Course display(int id) {
		 String display="select * from course where course_id="+String.valueOf(id);
		 Course course=null;
	        try{
	        	Connection conn = dataSource.getConnection();
	            Statement stmt=conn.createStatement();
	            ResultSet data=stmt.executeQuery(display);
	            while (data.next())
	            {
	                int c_fee=data.getInt(4);
	                int c_ID=data.getInt(1);
	                String c_name=data.getNString(2);
	                String c_desp=data.getNString(3);
	                String c_resource=data.getNString(5);
	                course=new Course(c_name,c_ID,c_resource,c_desp,c_fee);
	                System.out.println("Course_ID : "+c_ID+"\tCourse Name : "+c_name+"\tCourse_desp : "+c_desp+"\tCourse_Fees : "+c_fee+"\tCourse Resource : "+c_resource);
	            }
	            return course;
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        }
	    return course;
	}
}
