package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
	Document findByFormAdmissionFormId(long id);
}
