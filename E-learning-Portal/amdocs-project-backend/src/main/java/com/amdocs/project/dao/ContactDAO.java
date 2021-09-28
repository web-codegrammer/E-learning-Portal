package com.amdocs.project.dao;

import java.util.List;

import com.amdocs.project.model.Contact;

public interface ContactDAO {
    boolean create();
    List<Contact> display();
    List<Contact> display(int id);
    boolean saveContact(Contact contact);
    boolean delete(int contactid);
}
