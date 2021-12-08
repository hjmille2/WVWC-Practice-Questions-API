package com.hjmille2.wvwc.practice.questions.repository;

import com.hjmille2.wvwc.practice.questions.model.ShortAns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortAnsRepository extends JpaRepository<ShortAns, Long> {
    
}
