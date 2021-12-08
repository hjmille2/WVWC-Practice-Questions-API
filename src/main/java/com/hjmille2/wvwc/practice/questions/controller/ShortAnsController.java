package com.hjmille2.wvwc.practice.questions.controller;

import java.util.List;

import com.hjmille2.wvwc.practice.questions.model.ShortAns;
import com.hjmille2.wvwc.practice.questions.repository.ShortAnsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wvwc-practice-questions/v1")
public class ShortAnsController {
    
    @Autowired
    private ShortAnsRepository shortAnsRepository; 

    @GetMapping("/short_ans")
    public ResponseEntity<?> getAllShortAns(){
        List<ShortAns> shortAns = shortAnsRepository.findAll(); 

        return ResponseEntity.ok().body(shortAns); 
    }

    @GetMapping("/short_ans/{question_id}")
    public ResponseEntity<?> getShortAnsById(@PathVariable(value = "question_id") Long question_id){
        ShortAns shortAns = shortAnsRepository.getById(question_id); 

        return ResponseEntity.ok().body(shortAns); 
    }
}
