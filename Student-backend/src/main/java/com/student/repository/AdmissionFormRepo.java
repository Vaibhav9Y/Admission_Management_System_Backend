package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.AdmissionForm;
@Repository
public interface AdmissionFormRepo extends JpaRepository<AdmissionForm,Long >{

}
