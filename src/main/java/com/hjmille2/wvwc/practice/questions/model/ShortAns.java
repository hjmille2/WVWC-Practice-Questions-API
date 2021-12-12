package com.hjmille2.wvwc.practice.questions.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
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
    @Column(name="question_id")
    private Long question_id; 
    
    @Column(name="answer", table = "short_answer_questions", nullable = false)
    private String answer; 

    @Column(name="explanation", table = "short_answer_questions", nullable = true)
    private String shortAnsExplanation;

    @OneToOne
    @MapsId
    @JoinColumn(name="question_id")
    @Setter @Getter
    private Questions question; 
    
}
