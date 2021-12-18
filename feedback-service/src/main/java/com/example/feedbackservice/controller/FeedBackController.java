package com.example.feedbackservice.controller;

import com.example.feedbackservice.model.FeedBack;
import com.example.feedbackservice.service.FeedBackService;
import com.example.feedbackservice.service.iml.FeedBackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    FeedBackService feedBackService;

    @PostMapping
    public ResponseEntity<Long> addFeedBack(@RequestBody FeedBack feedBack){
        return ResponseEntity.ok(feedBackService.add_feedback(feedBack));
    }
    @GetMapping("/{id}")
    public ResponseEntity<FeedBack> getFeedBackById(@PathVariable Long id){
        return ResponseEntity.ok(feedBackService.get_feedback_by_id(id));
    }

    @GetMapping
    public ResponseEntity<List> allFeedBacks() {
        return ResponseEntity.ok(feedBackService.get_all_feedback());
    }
}
