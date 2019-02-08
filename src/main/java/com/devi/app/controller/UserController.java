package com.devi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devi.app.entity.User;
import com.devi.app.service.UserService;

@RestController
@RequestMapping(value="/user-management")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUser() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@DeleteMapping("/user")
	public String deleteUser(@RequestBody User user) {
		try {
			userService.deleteUser(user);
			return "user deleted successfully";
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	

}
