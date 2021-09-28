package com.amdocs.project.dao.impl;

import com.amdocs.project.dao.UserDAO;
import com.amdocs.project.db.DBUtils;
import com.amdocs.project.db.DataSourceUtil;
import com.amdocs.project.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDAOIMPL implements UserDAO {
	DataSource dataSource = DataSourceUtil.dataSource();
    @Override
    public boolean create() {
        String query="create table user(user_id int primary key auto_increment, name varchar(100),phone_no int8, email varchar(100), address varchar(100), reg_date date, password varchar(100), upload_photo long)";
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
    public List<User> display() {
        String display="select * from user";
        List<User> list=new ArrayList<>();
        User user=null;
        try{
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet data=stmt.executeQuery(display);
            while (data.next())
            {
                long phone=data.getLong(3);
                int user_ID=data.getInt(1);
                String name=data.getNString(2);
                String email=data.getNString(4);
                String address=data.getNString(5);
                Date date=data.getDate(6);
                String password=data.getNString(7);
                String image=data.getNString(8);
                user=new User(name,email,password,address,phone,image,user_ID,date);
                list.add(user);
                System.out.println("User_ID : "+user_ID+"\tName : "+name+"\tPhone : "+phone+"\tEmail : "+email+"\tAddress : "+address+"\tAddress : "+address+"\tDate : "+date+"\tPassword : "+password+"\tUpload_Image : "+image);
            }
            return list;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveUser(User user) {
        String insert = "insert into user values(?,?,?,?,?,?,?,?)";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(insert);
            ps.setNString(2,user.getName());
            ps.setInt(1,user.getUserID());
            ps.setNString(4,user.getEmail());
            ps.setLong(3,user.getPhone());
            ps.setNString(5,user.getAddress());
            ps.setDate(6,user.getDate());
            ps.setNString(7,user.getPassword());
            ps.setNString(8,user.getUploadImage());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int userid) {
        String query="delete from user where user_id=?";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setInt(1,userid);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public User display(int id) {
		String display="select * from user where user_id="+String.valueOf(id);
		User user=null;
        try{
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet data=stmt.executeQuery(display);
            while (data.next())
            {
                long phone=data.getLong(3);
                int user_ID=data.getInt(1);
                String name=data.getNString(2);
                String email=data.getNString(4);
                String address=data.getNString(5);
                Date date=data.getDate(6);
                String password=data.getNString(7);
                String image=data.getNString(8);
                user=new User(name,email,password,address,phone,image,user_ID,date);
                System.out.println("User_ID : "+user_ID+"\tName : "+name+"\tPhone : "+phone+"\tEmail : "+email+"\tAddress : "+address+"\tAddress : "+address+"\tDate : "+date+"\tPassword : "+password+"\tUpload_Image : "+image);
            }
            return user;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		String updatequery = "update user set name=?,phone=?,email=?,address=?,date=?,password=?,uploadImage=? where user_id=?";
		try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(updatequery);
            ps.setNString(2,user.getName());
            ps.setInt(1,user.getUserID());
            ps.setNString(4,user.getEmail());
            ps.setLong(3,user.getPhone());
            ps.setNString(5,user.getAddress());
            ps.setDate(6,user.getDate());
            ps.setNString(7,user.getPassword());
            ps.setNString(8,user.getUploadImage());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
