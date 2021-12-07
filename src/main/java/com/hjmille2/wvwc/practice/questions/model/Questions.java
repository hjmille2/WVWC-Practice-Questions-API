package com.hjmille2.wvwc.practice.questions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Table(name="questions") 
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long question_id; 

    @Column(name= "question_type", nullable= false)
    private String question_type;

    @Column(name= "question", nullable= false)
    private String question; 

    @Column(name= "question_category", nullable= false)
    private String question_category; 

    @Column(name= "question_class", nullable= true)
    private String question_class; 

}
