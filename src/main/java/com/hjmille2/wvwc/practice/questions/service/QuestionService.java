package com.hjmille2.wvwc.practice.questions.service;

import com.hjmille2.wvwc.practice.questions.exceptions.ResourceNotFoundException;
import com.hjmille2.wvwc.practice.questions.model.Question;

import org.springframework.stereotype.Component;

@Component
public interface QuestionService {
    
    public Question createNewQuestion(Question question);
    public Question createNewMultipleChoice(Question question); 
    public Question createNewShortAns(Question question); 

    public Question updateQuestion(Long questionId, Question newQuestionDetails) throws ResourceNotFoundException; 
    public Question updateMultipleChoice(Question question, Question newQuestionDetails); 
}
