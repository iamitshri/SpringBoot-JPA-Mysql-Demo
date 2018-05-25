package com.example.SpringBootJPADemo;

import java.util.stream.IntStream;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootJPADemo.domain.Address;
import com.example.SpringBootJPADemo.domain.Course;
import com.example.SpringBootJPADemo.domain.Passport;
import com.example.SpringBootJPADemo.domain.Person;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootJpaDemoApplication {

	@Autowired
	private EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDemoApplication.class, args);
	}

	 
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void dataGenerator(String... args) throws Exception {
		System.out.println("START CommandLineRunner");

		IntStream.range(1, 100)
				.forEach(n -> em.persist(createPerson("Person Name - " + RandomStringUtils.random(10, true, true),
						"Address - " + RandomStringUtils.random(10, true, true),
						"Course Name - " + RandomStringUtils.random(10, true, true),
						"" + RandomStringUtils.random(10, true, true))));

		System.out.println("STOP CommandLineRunner");

	}

	Person createPerson(String personName, String personAddr, String CourseName, String passportNum) {
		Person person = new Person();
		person.setName(personName);
		person.addCourse(new Course(CourseName));

		Address addr = new Address(personAddr);
		person.addAddress(addr);
		addr.setPerson(person);

		person.setPassport(new Passport(passportNum));
		return person;
	}
}
