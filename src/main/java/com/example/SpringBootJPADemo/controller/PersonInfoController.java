package com.example.SpringBootJPADemo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootJPADemo.domain.Address;
import com.example.SpringBootJPADemo.domain.Person;
import com.example.SpringBootJPADemo.repository.AddressRepository;
import com.example.SpringBootJPADemo.repository.PersonRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1")
public class PersonInfoController {

	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	AddressRepository addressRepo;

	@GetMapping(value = "/person/names")
	@ApiOperation("get person names")
	List<String> getPersonNames() {
		return personRepo.findAll().stream().map(person -> person.getName()).collect(Collectors.toList());
	}
	
	@PostMapping(value = "/address/person")
	@ApiOperation("get Address by person")
	Address getAddress(@RequestBody Person person) {
		return addressRepo.findByPerson(person);
	}
	
	

	@GetMapping(value = "/person/{passportNumber}")
	@ApiOperation("get Person by passport Id")
	Person getPersonByPassportNum(@PathVariable(name="passportNumber") String passportNumber) {
		return personRepo.getPersonByPassport(passportNumber);
	}

}
