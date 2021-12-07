package com.hjmille2.wvwc.practice.questions.controller;

import com.hjmille2.wvwc.practice.questions.repository.MultipleChoiceRepository;
import com.hjmille2.wvwc.practice.questions.repository.QuestionsRepository;

import java.util.List;

import com.hjmille2.wvwc.practice.questions.model.MultipleChoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/wvwc-practice-questions/v1")
public class MultipleChoiceController {
    
    @Autowired
    private MultipleChoiceRepository multipleChoiceRepository; 

    @GetMapping("mult_choice")
    public ResponseEntity<?> getAllMultipleChoice(){
        List<MultipleChoice> multChoiceQuestions = multipleChoiceRepository.findAll(); 

        return ResponseEntity.ok().body(multChoiceQuestions); 
    }

    @GetMapping("mult_choice/{question_id}")
    public ResponseEntity<?> getMultChoiceById(@PathVariable(value="question_id") Long question_id){
        MultipleChoice multChoice = multipleChoiceRepository.getById(question_id); 

        return ResponseEntity.ok().body(multChoice); 
    }
}
