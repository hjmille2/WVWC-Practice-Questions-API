package com.hjmille2.wvwc.practice.questions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mult_choice_questions") 
public class MultipleChoice {
    
    @Id
    @Column(name = "question_id")
    @Getter @Setter
    private Long question_id; 

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

    @OneToOne
    @MapsId
    @JoinColumn(name="question_id")
    @Setter
    @Getter
    private Questions question; 

}
