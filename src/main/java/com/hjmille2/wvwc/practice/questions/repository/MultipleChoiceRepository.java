package com.hjmille2.wvwc.practice.questions.repository;

import java.util.List;

import com.hjmille2.wvwc.practice.questions.model.MultipleChoice;
import com.hjmille2.wvwc.practice.questions.model.Questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleChoiceRepository extends JpaRepository<MultipleChoice, Long>{

}
