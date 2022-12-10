package com.student.service;
import java.util.List;

import com.student.dto.LoginDTO;
import com.student.entity.*;

public interface UserService {
	
 public User saveStudent(User user);

 public  List<User> getAllUsers();

public User getUserById(Long userId);

public User updateUserById(Long userId, User user);

public void deleteUserById(Long userId);

public User validate(LoginDTO dto);
	

}
