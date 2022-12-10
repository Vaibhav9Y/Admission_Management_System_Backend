package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Qualification;
@Repository
public interface QualificationRepo extends JpaRepository<Qualification, Long> {

}
