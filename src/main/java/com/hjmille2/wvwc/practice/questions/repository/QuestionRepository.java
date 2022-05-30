package com.hjmille2.wvwc.practice.questions.repository;

import java.util.List;

import com.hjmille2.wvwc.practice.questions.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

    @Query(
        value="SELECT * FROM questions WHERE question_type = 'mult_choice'",
        nativeQuery = true)
    List<Question> getAllMultipleChoice(); 

    @Query(
        value="SELECT * FROM questions WHERE question_type = 'short_ans'",
        nativeQuery = true)
    List<Question> getAllShortAns(); 

    @Query(
        value="SELECT DISTINCT question_class FROM questions",
        nativeQuery = true
    )
    List<String> getAllClasses(); 

    @Query(
        value="SELECT DISTINCT question_type FROM questions",
        nativeQuery = true
    )
    List<String> getAllQuestionTypes(); 
}