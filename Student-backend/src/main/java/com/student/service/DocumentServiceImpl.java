package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.DocumentUploadDTO;
import com.student.entity.AdmissionForm;
import com.student.entity.Document;
import com.student.repository.DocumentRepository;
import com.student.utils.StorageService;
@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired private DocumentRepository repo;
	@Autowired private StorageService storage;
	@Autowired private AdmissionFormService admission;
	
	@Override
	public void saveDocument(DocumentUploadDTO dto) {
		// TODO Auto-generated method stub
		AdmissionForm form=admission.getAdmissionFormById(dto.getFormid());
		Document doc=new Document();
		doc.setForm(form);
		doc.setForm(null);
		if(dto.getMat()!=null) {
			String mat=storage.store(dto.getMat());
			doc.setCertmat(mat);
		}
		if(dto.getGrad()!=null) {
			String grad=storage.store(dto.getGrad());
			doc.setCertgrad(grad);
		}
		if(dto.getInter()!=null) {
			String inter=storage.store(dto.getInter());
			doc.setCertinter(inter);
		}
		if(dto.getPg()!=null) {
			String pg=storage.store(dto.getPg());
			doc.setCertpg(pg);
		}
		repo.save(doc);
		form.setDocstatus("Uploaded");
		admission.SaveAddmissionForm(form);
	}

	@Override
	public Document findFormDocuments(long id) {
		// TODO Auto-generated method stub
		return repo.findByFormAdmissionFormId(id);
	}

}
