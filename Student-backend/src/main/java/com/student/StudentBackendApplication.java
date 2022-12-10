package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.student.utils.FileUploadProperties;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
@EnableConfigurationProperties({
    FileUploadProperties.class
})
public class StudentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentBackendApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
