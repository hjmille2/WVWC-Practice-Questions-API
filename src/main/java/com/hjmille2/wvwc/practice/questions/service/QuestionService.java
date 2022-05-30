package com.hjmille2.wvwc.practice.questions.service;

import com.hjmille2.wvwc.practice.questions.model.Question;

import org.springframework.stereotype.Component;

@Component
public interface QuestionService {
    
    public Question createNewQuestion(Question question);
    public Question createNewMultipleChoice(Question question); 
}
