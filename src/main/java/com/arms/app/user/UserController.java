package com.arms.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.arms.domain.component.PageWrapper;
import com.arms.domain.entity.User;
import com.arms.domain.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/users")
	public String list(Model model, Pageable pageable){
		Page<User> pageUserList = userService.getAllUsers(pageable);
//		model.addAttribute("page", pageUserList);
		PageWrapper<User> page = new PageWrapper<User>(pageUserList, "/users");
		model.addAttribute("page", page);
		model.addAttribute("users", page.getContent());
		model.addAttribute("url", "/users");
		return "user/list";
	}

}
