package com.example.SpringBootJPADemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootJPADemo.domain.Address;
import com.example.SpringBootJPADemo.domain.Person;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address findByPerson(Person p);
}
