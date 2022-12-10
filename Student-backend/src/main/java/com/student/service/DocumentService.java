package com.student.service;

import com.student.dto.DocumentUploadDTO;
import com.student.entity.Document;

public interface DocumentService {
	void saveDocument(DocumentUploadDTO dto);
	Document findFormDocuments(long id);
}
