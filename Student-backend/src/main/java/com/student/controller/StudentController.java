package com.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.DocumentUploadDTO;
import com.student.dto.StatusupdateDTO;
import com.student.entity.AdmissionForm;
import com.student.entity.Document;
import com.student.entity.User;
import com.student.service.AdmissionFormService;
import com.student.service.DocumentService;
import com.student.service.UserService;

@RestController
@CrossOrigin

public class StudentController {
	@Autowired
	private UserService userService;
	@Autowired
	private AdmissionFormService admissionFormService;
	@Autowired
	private DocumentService docservice;
	
	
	@PostMapping("/register")
	public String resisterStudent(@Valid @RequestBody User user) {
		try{
			userService.saveStudent(user);
			return "resistration is successfull plese login";
		} catch (DataIntegrityViolationException e) {
		    return "Email already exist";
		}
		
	}
	

	@PostMapping("/addmissionform")
	public AdmissionForm AdmissionFormFill(@Valid @RequestBody AdmissionForm admissionForm ) {
		return admissionFormService.SaveAddmissionForm(admissionForm);
		
		
//=========		Get Mappings    ==========
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") Long userId) {
		return userService.getUserById(userId);
	}
	@GetMapping("/admin/users")
	public List<User> getAllUsers() {
		return  userService.getAllUsers();
	}
	
	@GetMapping("/user/admissionform/{id}")
	public AdmissionForm getAdmissonFormById(@PathVariable("id")Long admissionFormId) {
		return admissionFormService.getAdmissionFormById(admissionFormId);	
	}
	
	//========= update status =============
	@PutMapping("status/{id}")
	public String updateStatus(@PathVariable("id") long id,StatusupdateDTO dto) {
		admissionFormService.updateFormStatus(id, dto.getStatus());
		return "Status Updated successfully";
	}
	
	@PutMapping("docstatus/{id}")
	public String updateDocumentStatus(@PathVariable("id") long id,StatusupdateDTO dto) {
		admissionFormService.updateDocumentStatus(id, dto.getStatus());
		return "Document status Updated successfully";
	}
	
//	======view application==========
	@GetMapping("/user/viewapplication/{id}")
	public AdmissionForm getAdmissonFormByUserId(@PathVariable("id")Long userId) {
		return admissionFormService.getAdmissionFormByUserId(userId);
	
	}
	
//	==========Put Mappings ===========
	@PutMapping("userupdate/{id}")
	public String updateUserById(@PathVariable("id") Long userId, @RequestBody User user) {
	userService.updateUserById(userId,user);
		return "User updated successfully";
	}
	
	
//	========Delete Mappings==========
	@DeleteMapping("deleteuser/{id}")
	public String deleteUserById(@PathVariable ("id")Long userId) {
		userService.deleteUserById(userId);
		return "User Deleted successfully";
	}
	
	@PostMapping("uploadDocuments")
	public String uploadDocs(DocumentUploadDTO dto) {
		docservice.saveDocument(dto);
		return "Document uploaded successfully";
	}
	
	@GetMapping("documents/{id}")
	public Document getDocuments(long id) {
		return docservice.findFormDocuments(id);
	}
}
