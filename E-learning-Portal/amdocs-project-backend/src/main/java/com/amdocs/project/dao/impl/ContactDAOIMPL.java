package com.amdocs.project.dao.impl;

import com.amdocs.project.dao.ContactDAO;
import com.amdocs.project.db.DBUtils;
import com.amdocs.project.db.DataSourceUtil;
import com.amdocs.project.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ContactDAOIMPL implements ContactDAO {
	DataSource dataSource = DataSourceUtil.dataSource();
    @Override
    public boolean create() {
        String query="create table contact(user_id int references user , name varchar(30), Email varchar(20), Phone_no int8, Message varchar(20), contact_id int8 primary key)";
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
    public List<Contact> display() {
        String display="select * from contact";
        List<Contact>list=new ArrayList<>(); 
        try{
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet data=stmt.executeQuery(display);
            while (data.next())
            {
                long phone=data.getLong(4);
                int user_ID=data.getInt(1);
                String name=data.getNString(2);
                String email=data.getNString(3);
                String message=data.getNString(5);
                int contact_ID=data.getInt(6);
                Contact contact=new Contact(user_ID,email,name,phone,message);
                list.add(contact);
                System.out.println("User_ID : "+user_ID+"\tName : "+name+"\tEmail : "+email+"\tPhone No : "+phone+"\tMessage : "+message+"\tContact_ID : "+contact_ID);
            }
            return list;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveContact(Contact contact) {
        String insert = "insert into contact(user_id,name,Email,Phone_no,Message) values(?,?,?,?,?)";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(insert);
            ps.setNString(2,contact.getName());
            ps.setInt(1,contact.getUserID());
            ps.setNString(3,contact.getEmail());
            ps.setLong(4,contact.getPhone());
            ps.setNString(5,contact.getMessage());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int contactid) {
        String query="delete from contact where contact_id=?";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setInt(1,contactid);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public List<Contact> display(int id) {
		// TODO Auto-generated method stub
        String display="select * from contact where user_id="+String.valueOf(id);
        List<Contact>list=new ArrayList<>();
        try{
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet data=stmt.executeQuery(display);
            while (data.next())
            {
                long phone=data.getLong(4);
                int user_ID=data.getInt(1);
                String name=data.getNString(2);
                String email=data.getNString(3);
                String message=data.getNString(5);
                int contact_ID=data.getInt(6);
                Contact contact=new Contact(user_ID,email,name,phone,message);
                list.add(contact);
                System.out.println("User_ID : "+user_ID+"\tName : "+name+"\tEmail : "+email+"\tPhone No : "+phone+"\tMessage : "+message+"\tContact_ID : "+contact_ID);
            }
            return list;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
	}
}
