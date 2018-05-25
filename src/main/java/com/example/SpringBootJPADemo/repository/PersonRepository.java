package com.example.SpringBootJPADemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SpringBootJPADemo.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Query("from Person p where p.passport.number=:passportNumber")
	Person getPersonByPassport(@Param("passportNumber") String passportNum);
}


/**

Create a complex quyery and create a specific DTO that serves the query result 
**/
