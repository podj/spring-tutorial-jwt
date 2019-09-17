package com.podj.itamar.demo.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(indexes = {@Index(unique = true, columnList = "email")})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String email;
	
	private String fullName;
	
	@JsonIgnore
	private String password;
	
}
