package com.arms.domain.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.arms.domain.entity.User;
import com.arms.domain.repository.UserRepository;

@Service
public class AppService {

	
	 @Autowired
	    UserRepository userRepository;
	 
	 public User findOne(Principal principal){
	    	if(principal == null){
	    		return null;
	    	} else {
	    		Authentication auth = (Authentication) principal;
	    		UserDetails userDetails = (UserDetails) auth.getPrincipal();
	    		return userRepository.findOneByEmail(userDetails.getUsername());
	    	}
	    }
}
