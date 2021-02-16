package com.arms.domain.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.arms.app.user.UserAddForm;
import com.arms.domain.component.MyPasswordEncoder;
import com.arms.domain.entity.User;

@Service
public class UserService extends AppService {
	
	@Autowired
	MyPasswordEncoder passwordEncoder;
	
	public void createUser(UserAddForm userAddForm) throws NoSuchAlgorithmException {
		User user = new User();
		user.setEmail(userAddForm.getEmail());
		user.setPassword(passwordEncoder.hashMD5(userAddForm.getPassword()));
		userRepository.save(user);
	}
	
	public Page<User> getAllUsers(Pageable pageable){
		return userRepository.findAll(pageable);
	}

}
