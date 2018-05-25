package com.example.SpringBootJPADemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootJPADemo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;
	
	

}
