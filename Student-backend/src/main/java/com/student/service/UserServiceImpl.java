package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.dto.LoginDTO;
import com.student.entity.User;
import com.student.repository.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder; 
	

	@Override
	public User saveStudent(User user) {
		System.out.println(user.getPassword());
		String ecodedPassword=passwordEncoder.encode(user.getPassword());
		System.out.println(ecodedPassword);
		user.setPassword(ecodedPassword);
		
		return userRepo.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		 return userRepo.getAllUsers();
		
	}


	@Override
	public User getUserById(Long userId) {
		
		return userRepo.findById(userId).get();
	}


	@Override
	public User updateUserById(Long userId, User user) {
		User userdb=userRepo.findById(userId).get();
		userdb.setFirstName(user.getFirstName());
		userdb.setLastName(user.getLastName());
		userdb.setEmail(user.getEmail());
			
			return userRepo.save(user);
	}


	@Override
	public void deleteUserById(Long userId) {
		userRepo.deleteById(userId);
		
	}


	@Override
	public User validate(LoginDTO dto) {
		// TODO Auto-generated method stub
		System.out.println(dto);
		Optional<User> user=userRepo.findByEmail(dto.getUserid());
		//String ecodedPassword=passwordEncoder.encode(dto.getPwd());
		
		if(user.isPresent() && passwordEncoder.matches(dto.getPwd(), user.get().getPassword())) {
			return user.get();
		}
		return null;
	}


	}


