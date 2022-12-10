package com.student.service;

import com.student.entity.AdmissionForm;

public interface AdmissionFormService {
	AdmissionForm SaveAddmissionForm(AdmissionForm admissionForm);

	AdmissionForm getAdmissionFormById(Long admissionFormId);

	AdmissionForm getAdmissionFormByUserId(Long userId);
	
	AdmissionForm updateFormStatus(long id,String status);
	
	AdmissionForm updateDocumentStatus(long id,String status);

}
