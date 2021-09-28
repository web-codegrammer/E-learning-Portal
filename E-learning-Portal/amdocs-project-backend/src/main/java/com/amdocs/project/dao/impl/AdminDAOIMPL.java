package com.amdocs.project.dao.impl;

import com.amdocs.project.dao.AdminDAO;
import com.amdocs.project.db.DBUtils;
import com.amdocs.project.db.DataSourceUtil;
import com.amdocs.project.model.Admin;

import java.sql.*;

import javax.sql.DataSource;

public class AdminDAOIMPL implements AdminDAO {
	DataSource dataSource = DataSourceUtil.dataSource();
    @Override
    public boolean create() {
        String query="create table admin (admin_id int8 primary key, name varchar(100),email varchar(100), password varchar(100))";
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
    public Admin display(int id) {
        String display="select * from admin where admin_id="+String.valueOf(id);
        Admin admin=null;
        try{
        	Connection conn = dataSource.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet data=stmt.executeQuery(display);
            while (data.next())
            {
                int admin_ID=data.getInt(1);
                String name=data.getNString(2);
                String email=data.getNString(3);
                String password=data.getNString(4);
                admin=new Admin(name,email,password,admin_ID);
                System.out.println("Admin_ID : "+admin_ID+"\tName : "+name+"\tEmail : "+email+"\tPassword : "+password);
            }
            return admin;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public boolean saveAdmin(Admin admin) {
        String insert = "insert into admin values(?,?,?,?)";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(insert);
            ps.setInt(1,admin.getAdminID());
            ps.setNString(2,admin.getName());
            ps.setNString(3,admin.getEmail());
            ps.setNString(4,admin.getPassword());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int adminid) {
        String query="delete from admin where admin_id=?";
        try{
        	Connection conn = dataSource.getConnection();
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setInt(1,adminid);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
