package com.hjmille2.wvwc.practice.questions.Services;

import com.hjmille2.wvwc.practice.questions.model.MultipleChoice;
import com.hjmille2.wvwc.practice.questions.model.MultipleChoiceRequest;
import com.hjmille2.wvwc.practice.questions.model.Questions;
import com.hjmille2.wvwc.practice.questions.model.ShortAns;
import com.hjmille2.wvwc.practice.questions.model.ShortAnswerRequest;
import com.hjmille2.wvwc.practice.questions.repository.MultipleChoiceRepository;
import com.hjmille2.wvwc.practice.questions.repository.QuestionsRepository;
import com.hjmille2.wvwc.practice.questions.repository.ShortAnsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository; 

    @Autowired
    private MultipleChoiceRepository multipleChoiceRepository; 

    @Autowired
    private ShortAnsRepository shortAnsRepository; 

    public MultipleChoiceRequest createMultipleChoiceQuestion(MultipleChoiceRequest requestBody){
        Questions question = questionsRepository.save(requestBody.getQuestion()); 
        MultipleChoice multChoice = requestBody.getMultipleChoice(); 
        multChoice.setQuestion(question);
        question.setMult_choice(multChoice); 
        
        multChoice = multipleChoiceRepository.save(multChoice);  

        return new MultipleChoiceRequest(question, multChoice); 
    }

    public ShortAnswerRequest createShortAnswerQuestions(ShortAnswerRequest requestBody){
        Questions question = questionsRepository.save(requestBody.getQuestion()); 
        ShortAns shortAns = requestBody.getShortAns(); 
        shortAns.setQuestion(question); 
        question.setShortAns(shortAns); 

        shortAns = shortAnsRepository.save(shortAns); 

        return new ShortAnswerRequest(question, shortAns); 
    }
}
