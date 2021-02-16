package com.arms.domain.service;

import com.arms.domain.entity.User;

public interface UserAccountService {
	
	User findOneByEmail(String username);

}
