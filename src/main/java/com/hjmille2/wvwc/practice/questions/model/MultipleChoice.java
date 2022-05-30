package com.hjmille2.wvwc.practice.questions.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="mult_choice_questions") 
public class MultipleChoice {
    
    @Id
    @Column(name="mult_choice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mult_choice_id; 
    
    @Getter @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "question_id", nullable = false)
    @JsonBackReference
    private Question question; 

    @Column(name = "correct_ans", nullable = false)
    @Getter @Setter
    private String correct_ans;

    @Column(name = "opt_1", nullable = false)
    @Getter @Setter
    private String opt_1; 

    @Column(name = "opt_2", nullable = false)
    @Getter @Setter
    private String opt_2;

    @Column(name = "opt_3", nullable = true)
    @Getter @Setter
    private String opt_3; 

    @Column(name = "explanation", nullable = true)
    @Getter @Setter
    private String explanation;

}
