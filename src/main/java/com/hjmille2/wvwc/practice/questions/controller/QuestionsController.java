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
    public ResponseEntity<?> getAllQuestions() {
        List<Question> questions = questionsRepository.findAll(); 
        return ResponseEntity.ok().body(questions);  
    }

    // @GetMapping("/questions/{question_id}")
    // public ResponseEntity<Questions> getQuestionById(@PathVariable(value="question_id") Long question_id)
    //     throws ResourceNotFoundException {
    //         Questions question = questionsRepository.findById(question_id).orElseThrow(
    //             () -> new ResourceNotFoundException("Question not found on :: " + question_id)
    //         ); 

    //         return ResponseEntity.ok().body(question); 
    // }

    @GetMapping("/questions/mult_choice")
    public ResponseEntity<?> getMultipleChoice(){
         List<Question> questions = questionsRepository.getAllMultipleChoice(); 
         return ResponseEntity.ok().body(questions); 
    }


    // @GetMapping("/questions/short_ans")
    // public ResponseEntity<?> getShortAns(){
    //     List<Questions> questions = questionsRepository.getAllShortAns(); 
    //     return ResponseEntity.ok().body(questions); 
    // }

    // @GetMapping("/questions/classes")
    // public ResponseEntity<?> getAllClasses(){
    //     List<String> classes = questionsRepository.getAllClasses();
    //     return ResponseEntity.ok().body(classes); 
    // }

    // @GetMapping("/questions/question_types")
    // public ResponseEntity<?> getAllQuestionTypes(){
    //     List<String> questionTypes = questionsRepository.getAllQuestionTypes();
    //     return ResponseEntity.ok().body(questionTypes); 
    // }

    @PostMapping("/questions")
    public ResponseEntity<?> createNewMultipleChoice(@RequestBody Question request){ 
         Question questionResp = questionService.createNewQuestion(request);

        return ResponseEntity.ok().body(questionResp); 
    }

    // // @PostMapping("/questions/short_ans")
    // // public ResponseEntity<?> createNewShortAns(@RequestBody ShortAnswerRequest request){
    // //     ShortAnswerRequest shortAnsRequest = questionsService.createShortAnswerQuestions(request); 

    // //     return ResponseEntity.ok().body(shortAnsRequest); 
    // // }
    

    // @PutMapping("/questions/{question_id}")
    // public ResponseEntity<Questions> updateQuestion(
    //     @PathVariable(value="question_id") Long question_id, @Valid @RequestBody Questions questionDetails
    // ) throws ResourceNotFoundException{
    //     Questions question = questionsRepository.findById(question_id).orElseThrow(
    //         () -> new ResourceNotFoundException("Question not found on :: " + question_id)
    //     ); 

    //     question.setQuestion_type(questionDetails.getQuestion_type()); 
    //     question.setQuestion(questionDetails.getQuestion());
    //     question.setQuestion_category(questionDetails.getQuestion_category());
    //     question.setQuestion_class(questionDetails.getQuestion_class());

    //     final Questions updatedQuestion = questionsRepository.save(question); 

    //     return ResponseEntity.ok(updatedQuestion); 
    // }
}
