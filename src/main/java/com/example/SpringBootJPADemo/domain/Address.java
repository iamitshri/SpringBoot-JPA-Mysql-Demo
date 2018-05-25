package com.example.SpringBootJPADemo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue
	private int address_id;

	private String street;
	
	public Address(String street){
		this.street = street;
	}

	@JsonIgnore()
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "person_id")
	Person person;

	public String toString() {
		return "Address: address_id" + address_id + ", Street:" + street + ", person: " + person.getName();
	}
}
