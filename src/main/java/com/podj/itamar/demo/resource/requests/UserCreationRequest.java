package com.podj.itamar.demo.resource.requests;

import lombok.Data;

@Data
public class UserCreationRequest {
	
	private String fullName;
	private String email;
	private String password;
	
}