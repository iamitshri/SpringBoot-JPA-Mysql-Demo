package com.example.SpringBootJPADemo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue
	private int id;

	Person(String name) {
		this.name = name;
	}

	@Column(name = "person_name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	private List<Address> addresses = new ArrayList<>();;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name = "passport_id")
	private Passport passport;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "PersonCourse", joinColumns = @JoinColumn(name = "person_id",referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName="id"))
	private List<Course> courses = new ArrayList<>();

	public void addAddress(Address addr) {
		this.addresses.add(addr);
	}

	public void addCourse(Course c) {
		this.courses.add(c);
	}

	public String toString() {
		return "id:" + id + ", name:" + name + ", address:"
				+ String.join("--", addresses.stream().map(addr -> addr.getStreet()).collect(Collectors.toList()));
	}
}
