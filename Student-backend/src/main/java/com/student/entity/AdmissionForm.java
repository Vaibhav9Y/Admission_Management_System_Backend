package com.student.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "Addmission_Form", uniqueConstraints = @UniqueConstraint(columnNames = "userId"))
@Data
@NoArgsConstructor
@AllArgsConstructor


public class AdmissionForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long admissionFormId;
	@NotBlank(message="Cource applied is required ")
	private String courseApplied;
	@NotBlank(message="father name is required ")
	private String fathersName;
	@NotBlank(message="Mother name is required ")
	private String mothersName;
	@NotBlank(message="Date of birth is required ")
	private String dob;
	@NotBlank(message="Nationality is required ")
	private String nationality;
	@NotBlank(message="Gender is required ")
	private String gender;
	private String category;
	@NotBlank(message="Correspondence address is required ")
	private String correspondenceAddress;
	@NotBlank(message="Permanent address is required ")
	private String permanentAddress;
	
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(name="qulificationId", referencedColumnName = "qualificationId")
	private Qualification qualification;
	
	private String status;//Pending,Accpeted,Rejected
	private String docstatus;//Pending,Accpeted,Rejected
	private String appremarks; //Application Reject reason
	private String docremarks; //Document Reject reason

	private Long userId;
	
	
	

	
}
