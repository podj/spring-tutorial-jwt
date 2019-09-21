package com.podj.itamar.demo.domain.services;

import com.podj.itamar.demo.domain.models.User;
import com.podj.itamar.demo.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCrudService {
	
	private final UserRepository userRepository;
	
	public UserCrudService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void create(User user) {
		userRepository.save(user);
	}
	
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
}
