package com.hjmille2.wvwc.practice.questions.service;

import com.hjmille2.wvwc.practice.questions.exceptions.ResourceNotFoundException;
import com.hjmille2.wvwc.practice.questions.model.MultipleChoice;
import com.hjmille2.wvwc.practice.questions.model.Question;
import com.hjmille2.wvwc.practice.questions.model.ShortAns;
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
            return createNewShortAns(question); 
        }
    }

    public Question createNewMultipleChoice(Question question){
        MultipleChoice multChoice = question.getMult_choice(); 
        multChoice.setQuestion(question); 
        return questionRepository.save(question);
    }

    public Question createNewShortAns(Question question){
        ShortAns shortAns = question.getShort_ans(); 
        shortAns.setQuestion(question); 
        return questionRepository.save(question); 
    }

    public Question updateQuestion(Long questionId, Question newQuestionDetails)
        throws ResourceNotFoundException{
        Question question = questionRepository.findById(questionId)
        .map( q -> {
            if(q.getQuestion_type().equals("mult_choice")){
                return updateMultipleChoice(q, newQuestionDetails);
            } 
            else {
                //will be changed in future with short ans
                return updateShortAns(q, newQuestionDetails); 
            }
        })
        .orElseThrow(
            () -> new ResourceNotFoundException("Question not found on :: " + questionId)
        ); 

        return question; 
    }

    public Question updateMultipleChoice(Question question, Question newQuestionDetails){
        //update question
        updateQuestionValues(question, newQuestionDetails); 

        MultipleChoice multChoice = question.getMult_choice(); 
        multChoice.setQuestion(question);
        multChoice.setCorrect_ans(newQuestionDetails.getMult_choice().getCorrect_ans()); 
        multChoice.setExplanation(newQuestionDetails.getMult_choice().getExplanation());
        multChoice.setOpt_1(newQuestionDetails.getMult_choice().getOpt_1()); 
        multChoice.setOpt_2(newQuestionDetails.getMult_choice().getOpt_2()); 
        multChoice.setOpt_3(newQuestionDetails.getMult_choice().getOpt_3()); 

        return questionRepository.save(question); 
    }

    public Question updateShortAns(Question question, Question newQuestionDetails){
        updateQuestionValues(question, newQuestionDetails); 

        ShortAns shortAns = question.getShort_ans(); 
        shortAns.setQuestion(question); 
        shortAns.setAnswer(newQuestionDetails.getShort_ans().getAnswer());
        shortAns.setExplanation(newQuestionDetails.getShort_ans().getExplanation());

        return questionRepository.save(question); 
    }

    private Question updateQuestionValues(Question question, Question newQuestionDetails){
        question.setQuestion(newQuestionDetails.getQuestion()); 
        question.setQuestion_category(newQuestionDetails.getQuestion_category()); 
        question.setQuestion_class(newQuestionDetails.getQuestion_class()); 
        question.setQuestion_type(newQuestionDetails.getQuestion_type()); 

        return question; 
    }
}
