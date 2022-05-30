package com.hjmille2.wvwc.practice.questions.service;

import com.hjmille2.wvwc.practice.questions.model.MultipleChoice;
import com.hjmille2.wvwc.practice.questions.model.Question;
import com.hjmille2.wvwc.practice.questions.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository; 
    
    public Question createNewQuestion(Question question){
        if(question.getQuestion_type().equals("mult_choice")){
            return createNewMultipleChoice(question); 
        }
        else {
            return question; 
        }
    }

    public Question createNewMultipleChoice(Question question){
        MultipleChoice multChoice = question.getMult_choice(); 
        multChoice.setQuestion(question); 
        return questionRepository.save(question);
    }
}
