package com.podj.itamar.demo.resource.controllers;

import com.podj.itamar.demo.domain.models.User;
import com.podj.itamar.demo.domain.services.UserCrudService;
import com.podj.itamar.demo.resource.requests.UserCreationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users", produces = "application/json", consumes = "application/json")
public class UserController {
	
	private final UserCrudService userCrudService;
	
	public UserController(UserCrudService userCrudService) {
		this.userCrudService = userCrudService;
	}
	
	@GetMapping
	public Iterable<User> findAll() {
		return userCrudService.findAll();
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
		return userCrudService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody UserCreationRequest request) {
		// I want the code to be minimal so I'll skip any mapping using another class,
		// We will just do it manually in here.
		User userToPersist = new User();
		userToPersist.setEmail(request.getEmail());
		userToPersist.setFullName(request.getFullName());
		userToPersist.setPassword(request.getPassword());
		
		userCrudService.create(userToPersist);
	}
	
}
