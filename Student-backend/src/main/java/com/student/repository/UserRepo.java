package com.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
@Query(value="SELECT * FROM user where role='user'",nativeQuery=true)
	List<User> getAllUsers();

}

