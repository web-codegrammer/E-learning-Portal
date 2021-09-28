package com.amdocs.project.dao;

import java.util.List;

import com.amdocs.project.model.User;

public interface UserDAO {
	boolean create();
    List<User> display();
    User display(int id);
    boolean saveUser(User user);
    boolean delete(int userid);
    public boolean updateUser(User user);
}
