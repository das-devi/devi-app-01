package com.devi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devi.app.entity.User;
import com.devi.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	public User createUser(User user){
		return this.userRepository.save(user);
	}
	
	public void deleteUser(User user){
		this.userRepository.deleteById(user.getId());
	}

}
