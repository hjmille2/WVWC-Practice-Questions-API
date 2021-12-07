package com.hjmille2.wvwc.practice.questions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name="mult_choice_questions") 
public class MultipleChoice {
    
    @Id
    @Column(name = "question_id")
    private Long question_id; 

    @Column(name = "correct_ans", nullable = false)
    private String correct_ans;

    @Column(name = "opt_1", nullable = false)
    private String opt_1; 

    @Column(name = "opt_2", nullable = false)
    private String opt_2;

    @Column(name = "opt_3", nullable = true)
    private String opt_3; 

    @Column(name = "explanation", nullable = true)
    private String explanation; 

}
