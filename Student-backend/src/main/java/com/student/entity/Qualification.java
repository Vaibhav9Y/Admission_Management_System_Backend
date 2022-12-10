package com.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "education_qualification")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long qualificationId;
//	ssc details
	@NotBlank(message="SSC board is required ")
	private String sscBoard;
	@NotBlank(message="SSC year is required ")
	@Size(min=4,max=4,message="Not a Valid SSC year")
	private String sscYear;
	@NotNull(message="SSC percentage is required ")
	private double sscPercentage;
	@NotBlank(message="SSC Stream is required ")
	private String sscStream;
	
//	Hsc details
	private String hscBoard;
	private String hscYear;
	private double hscPercentage;
	private String hscStream;
	
//	Graduation details
	@NotBlank(message="Graduation Board is required ")
	private String graduationBoard;
	@NotBlank(message="Graduation Year is required ")
	@Size(min=4,max=4,message="Not a Valid Graduation year")
	private String graduationYear;
	@NotNull(message="Graduatin percentage is required ")
	private double graduationPercentage;
	@NotBlank(message="Graduation Strem is required ")
	private String graduationStream;
	
//	Post graduation details
	private String postGraduationBoard;
	private String postGraduationYear;
	private double postGraduationPercentage;
	private String postGraduationStream;
	
	
//	@OneToOne(mappedBy = "qualifcation",cascade = CascadeType.ALL)
//	private AddmissionForm addmissionForm;
}
