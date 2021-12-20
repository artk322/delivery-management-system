package com.example.feedbackservice.service;

import com.example.feedbackservice.model.FeedBack;

import java.util.List;

public interface FeedBackService {

    Long add_feedback(FeedBack feedBack);

    FeedBack get_feedback_by_id(Long id);

    List<FeedBack> get_all_feedback();


}
