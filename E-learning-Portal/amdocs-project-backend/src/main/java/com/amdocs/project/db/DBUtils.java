package com.amdocs.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static String url_name = "jdbc:mysql://localhost:3306/amdocs_project";
    private static String user = "root";
    private static String pass = "devanshu452";

    private static Connection conn=null;

    private DBUtils(){

    }

    public static Connection getConn() {
        if(conn==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn= DriverManager.getConnection(url_name,user,pass);
                System.out.println("Done");
                return conn;
            }
            catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return null;
    }
}
