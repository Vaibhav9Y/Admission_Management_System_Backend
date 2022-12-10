package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.LoginDTO;
import com.student.dto.LoginResponse;
import com.student.entity.User;
import com.student.service.UserService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired UserService uservice;
	
	@PostMapping("validate")
	public ResponseEntity<?> validate(@RequestBody LoginDTO dto){
		User user=uservice.validate(dto);
		if(user==null) {
			return ResponseEntity.badRequest().body("Invalid username or password");			
		}else {
			LoginResponse response=new LoginResponse();
			response.setId(user.getUserId());
			response.setRole(user.getRole());
			response.setUname(user.getFirstName()+ " "+user.getLastName());
			response.setUserid(user.getEmail());
			return ResponseEntity.ok(response);
		}
	}
}
