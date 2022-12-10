package com.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@NotBlank (message ="First name is required.")
	private String firstName;
	@NotBlank (message ="Last name is required.")
	private String lastName;
	@Email (message ="Not a valid Email ")
	@NotBlank (message ="Email is required.")
	private String email;
	@NotNull (message ="PhoneNo is required.")
	@Pattern(regexp="[\\d]{10}" , message ="Phone number must be a number and of 10 digits")
	private String phoneNo;
	@NotBlank(message ="Password  is required.")
	@Size (min = 5 , message ="Password must be greater than 8 digit.")
	private String password;
	
	@Column(length = 20)
	private String role; //Admin/Student
	
}

