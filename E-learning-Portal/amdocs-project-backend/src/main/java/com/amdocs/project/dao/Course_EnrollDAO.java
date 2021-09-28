package com.amdocs.project.dao;
import java.util.List;

public interface Course_EnrollDAO {
	List<Integer> display(int id);
	boolean delete(int id,int id2);
	boolean enroll(int id,int id2);

}
