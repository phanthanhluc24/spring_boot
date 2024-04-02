package com.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.security.models.Role;
import com.security.security.models.User;
import com.security.security.repositories.UserRepository;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	public void run(String...args){
		User adminAccount=userRepository.findByRole(Role.ADMIN);
		if (adminAccount==null) {
			User admin=new User();
			
			admin.setFullname("Phan Thanh Luc");
			admin.setEmail("phanthanhluc2003@gmail.com");
			admin.setRole(Role.ADMIN);
			admin.setPassword(new BCryptPasswordEncoder().encode("Luc@gmail.com"));
			userRepository.save(admin);
		}
	}
}
