package com.example.feedbackservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedBack {
    private Long id;
    private String header;
    private String body;
    private double rating;

}
