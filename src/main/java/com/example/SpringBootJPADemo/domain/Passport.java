package com.example.SpringBootJPADemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passport {

	@Id
	@GeneratedValue
	private int id;

	String number;

	public Passport(String number){
		this.number = number;
	}
	
	@OneToOne(mappedBy = "passport")
	Person person;

	public String toString() {
		return "Passport: number:" + number + ", person: " + person.getName();
	}
}
