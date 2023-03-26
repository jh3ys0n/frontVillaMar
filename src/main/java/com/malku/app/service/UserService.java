package com.malku.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.malku.app.persistence.entity.User;
import com.malku.app.persistence.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
    private ModelMapper modelMapper;
    
    
    
	public UserService(UserRepository userRepository, ModelMapper modelMapper) {
		
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}



	public Iterable<User> findAll() {
		
		return userRepository.findAll();
	}



	public User createUser(User user) {
		User res=new User(user.getName(), user.getPassword());
		return userRepository.save(res);
	}



	public void guardar(String nombre, String pass) {
		User user=new User(nombre, pass);
		userRepository.save(user);
	}

}
