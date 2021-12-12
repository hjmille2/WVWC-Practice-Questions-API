package com.hjmille2.wvwc.practice.questions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShortAnswerRequest {
    
    private Questions question; 
    private ShortAns shortAns; 
}
