package com.amdocs.project.dao;


import com.amdocs.project.model.Admin;

public interface AdminDAO {
	boolean create();
    Admin display(int id);
    boolean saveAdmin(Admin admin);
    boolean delete(int adminid);
}
