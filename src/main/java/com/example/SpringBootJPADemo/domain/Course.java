package com.example.SpringBootJPADemo.domain;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue
	private int id;

	private String courseName;

	public Course(String course) {
		this.courseName = course;
	}
	
	@ManyToMany(mappedBy="courses")
	private List<Person> persons;
	
	void addPerson(Person p){
		this.persons.add(p);
	}
 
	public String toString() {
		return " Course: courseName:" + courseName + ", person: "
				+ String.join("--", persons.stream().map(person -> person.getName()).collect(Collectors.toList()));
	}

}
