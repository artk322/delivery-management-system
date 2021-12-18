package com.example.feedbackservice.service.iml;

import com.example.feedbackservice.model.FeedBack;
import com.example.feedbackservice.service.FeedBackService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    private List<FeedBack> feedBacks = new ArrayList<>();


    @Override
    public Long add_feedback(FeedBack feedBack) {
        feedBacks.add(feedBack);
        return feedBack.getId();
    }

    @Override
    public FeedBack get_feedback_by_id(long id) {
        for (FeedBack feedBack : feedBacks){
            if(feedBack.getId() == id){
                return feedBack;
            }
        }
        return null;
    }

    @Override
    public List<FeedBack> get_all_feedback() {
        return feedBacks;
    }
}
