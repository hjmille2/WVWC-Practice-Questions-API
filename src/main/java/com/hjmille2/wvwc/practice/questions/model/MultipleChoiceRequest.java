package com.hjmille2.wvwc.practice.questions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MultipleChoiceRequest {
    private Questions question; 

    private MultipleChoice multipleChoice; 
}
