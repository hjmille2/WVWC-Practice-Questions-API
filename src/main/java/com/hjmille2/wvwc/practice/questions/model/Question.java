package com.hjmille2.wvwc.practice.questions.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="questions") 
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "question_id")
    private Long question_id; 

    @Getter @Setter
    @Column(name= "question_type", nullable= false)
    private String question_type;

    @Getter @Setter
    @Column(name= "question", nullable= false)
    private String question; 

    @Getter @Setter
    @Column(name= "question_category", nullable= false)
    private String question_category; 

    @Getter @Setter
    @Column(name= "question_class", nullable= true)
    private String question_class; 

    @Getter @Setter
    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private MultipleChoice mult_choice; 

}
