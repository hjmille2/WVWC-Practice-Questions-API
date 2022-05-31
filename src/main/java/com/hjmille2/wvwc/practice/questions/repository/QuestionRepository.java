package com.hjmille2.wvwc.practice.questions.repository;

import java.util.List;

import com.hjmille2.wvwc.practice.questions.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(
        value="SELECT * FROM questions WHERE"
            + "(question_type IN :question_type OR COALESCE(:question_type) IS NULL)"
            + "AND (question_category IN (:question_category) OR COALESCE(:question_category) IS NULL)"
            + "AND (question_class IN (:question_class) OR COALESCE(:question_category) IS NULL)",
        nativeQuery = true
    )
    List<Question> getAllQuestions(
        @Param("question_type") String[] question_type,
        @Param("question_category") String[] question_category,
        @Param("question_class") String[] question_class
    );
}
