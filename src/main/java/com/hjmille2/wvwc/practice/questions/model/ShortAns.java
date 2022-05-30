package com.hjmille2.wvwc.practice.questions.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="short_answer_questions") 
public class ShortAns {

    @Id
    @Column(name="mult_choice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long short_ans_id; 

    @Column(name = "question_id")
    @Getter @Setter
    private Long question_id;  
    
    @Column(name="answer", table = "short_answer_questions", nullable = false)
    private String answer; 

    @Column(name="explanation", table = "short_answer_questions", nullable = true)
    private String shortAnsExplanation;
    
}
