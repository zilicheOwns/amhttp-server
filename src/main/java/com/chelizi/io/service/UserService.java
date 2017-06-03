package com.chelizi.io.service;

import com.chelizi.io.bean.User;
import com.chelizi.io.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(int id){
		return userRepository.getUser(id);
	}
}
