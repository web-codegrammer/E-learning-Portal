package com.amdocs.project.dao.impl;

import com.amdocs.project.dao.FeedbackDAO;
import com.amdocs.project.db.DBUtils;
import com.amdocs.project.db.DataSourceUtil;
import com.amdocs.project.model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class FeedbackDAOIMPL implements FeedbackDAO {
	DataSource dataSource = DataSourceUtil.dataSource();
    @Override
    public boolean create() {
        String query="create table feedback(user_id int references user, name varchar(100), email varchar(100), f_id int8 primary key, feedback varchar(100))";
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
    public List<Feedback> display() {
        String display="select * from feedback";
        List<Feedback>list=new ArrayList<>();
        try{
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet data=stmt.executeQuery(display);
            while (data.next())
            {
                int feedback_ID=data.getInt(4);
                int user_ID=data.getInt(1);
                String name=data.getNString(2);
                String email=data.getNString(3);
                String feedback=data.getNString(5);
                Feedback feed=new Feedback(user_ID,name,email,feedback);
                list.add(feed);
                System.out.println("Feedback_ID : "+feedback_ID+"\tUser_ID : "+user_ID+"\tName : "+name+"\tEmail : "+email+"\tFeedback : "+feedback);
            }
            return list;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveFeedback(Feedback feedback) {
        String insert = "insert into feedback(user_id,name,email,feedback) values(?,?,?,?)";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(insert);
            ps.setNString(2,feedback.getName());
            ps.setInt(1,feedback.getUserID());
            ps.setNString(3,feedback.getEmail());
            ps.setNString(4,feedback.getFeedback());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int feedbackid) {
        String query="delete from feedback where f_id=?";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setInt(1,feedbackid);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public List<Feedback> display(int id) {
		String display="select * from feedback where user_id="+String.valueOf(id);
        List<Feedback>list=new ArrayList<>();
        try{
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet data=stmt.executeQuery(display);
            while (data.next())
            {
                int feedback_ID=data.getInt(4);
                int user_ID=data.getInt(1);
                String name=data.getNString(2);
                String email=data.getNString(3);
                String feedback=data.getNString(5);
                Feedback feed=new Feedback(user_ID,name,email,feedback);
                list.add(feed);
                System.out.println("Feedback_ID : "+feedback_ID+"\tUser_ID : "+user_ID+"\tName : "+name+"\tEmail : "+email+"\tFeedback : "+feedback);
            }
            return list;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
	}

}
