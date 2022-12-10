package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.AdmissionForm;
import com.student.repository.AdmissionFormRepo;
@Service
public class AdmissionFormServiceImpl implements AdmissionFormService {
	@Autowired
	private AdmissionFormRepo admissionFormRepo;
	@Override
	public AdmissionForm SaveAddmissionForm(AdmissionForm admissionForm) {
		return  admissionFormRepo.save(admissionForm);
		
	}
	@Override
	public AdmissionForm getAdmissionFormById(Long admissionFormId) {
		
		return admissionFormRepo.findById(admissionFormId).get();
	}
	@Override
	public AdmissionForm getAdmissionFormByUserId(Long userId) {
		
		return admissionFormRepo.findById(userId).get();
	}
	
	@Override
	public AdmissionForm updateFormStatus(long id, String status) {
		AdmissionForm form=getAdmissionFormById(id);
		form.setStatus(status);
		admissionFormRepo.save(form);
		return form;
	}
	
	@Override
	public AdmissionForm updateDocumentStatus(long id, String status) {
		AdmissionForm form=getAdmissionFormById(id);
		form.setDocstatus(status);
		admissionFormRepo.save(form);
		return form;
	}

}
