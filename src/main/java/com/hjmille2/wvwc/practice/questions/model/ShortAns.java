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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="short_answer_questions") 
public class ShortAns {

    @Id
    @Column(name="short_ans_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long short_ans_id; 

    @Getter @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "question_id", nullable = false)
    @JsonBackReference
    private Question question;  
    
    @Getter @Setter
    @Column(name="answer", nullable = false)
    private String answer; 

    @Getter @Setter
    @Column(name="explanation", nullable = true)
    private String explanation;
    
}
