package com.hjmille2.wvwc.practice.questions.controller;

import java.util.List;

import javax.validation.Valid;

import com.hjmille2.wvwc.practice.questions.exceptions.ResourceNotFoundException;
import com.hjmille2.wvwc.practice.questions.model.MultipleChoice;
import com.hjmille2.wvwc.practice.questions.model.Question;
import com.hjmille2.wvwc.practice.questions.repository.QuestionRepository;
import com.hjmille2.wvwc.practice.questions.service.QuestionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/wvwc-practice-questions/v1")
public class QuestionsController {
    @Autowired
    private QuestionRepository questionsRepository; 

    @Autowired
    private QuestionServiceImpl questionService; 

    @GetMapping("/questions")
    public ResponseEntity<?> getAllQuestions(
        @RequestParam(required = false) String[] question_type,
        @RequestParam(required = false) String[] question_category,
        @RequestParam(required = false) String[] question_class
    ) {
        List<Question> questions = questionsRepository.getAllQuestions(question_type, question_category, question_class);
        return ResponseEntity.ok().body(questions);  
    }

    @GetMapping("/questions/mult_choice")
    public ResponseEntity<?> getMultipleChoice(){
         List<Question> questions = questionsRepository.getAllMultipleChoice(); 
         return ResponseEntity.ok().body(questions); 
    }


    @GetMapping("/questions/short_ans")
    public ResponseEntity<?> getShortAns(){
        List<Question> questions = questionsRepository.getAllShortAns(); 
        return ResponseEntity.ok().body(questions); 
    }

    @GetMapping("/questions/classes")
    public ResponseEntity<?> getAllClasses(){
        List<String> classes = questionsRepository.getAllClasses();
        return ResponseEntity.ok().body(classes); 
    }

    @GetMapping("/questions/question_types")
    public ResponseEntity<?> getAllQuestionTypes(){
        List<String> questionTypes = questionsRepository.getAllQuestionTypes();
        return ResponseEntity.ok().body(questionTypes); 
    }

    @PostMapping("/questions")
    public ResponseEntity<?> createNewQuestion(@RequestBody Question request){ 
         Question questionResp = questionService.createNewQuestion(request);

        return ResponseEntity.ok().body(questionResp); 
    }
    

    @PutMapping("/questions/{question_id}")
    public ResponseEntity<Question> updateQuestion(
        @PathVariable(value="question_id") Long question_id, @Valid @RequestBody Question questionDetails
    ) throws ResourceNotFoundException{
        Question updatedQuestion = questionService.updateQuestion(question_id, questionDetails); 

        return ResponseEntity.ok(updatedQuestion); 
    }
}
