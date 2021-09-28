package com.amdocs.project.dao;


import java.util.List;

import com.amdocs.project.model.Feedback;

public interface FeedbackDAO {
    boolean create();
    List<Feedback> display(int id);
    List<Feedback> display();
    boolean saveFeedback(Feedback feedback);
    boolean delete(int feedbackid);
}
