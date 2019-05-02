package com.puthisastra.first;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Modifying
	@Transactional
	@Query("update Person p set p.firstName = ?1 where p.age = ?2")
	int setName(String firstname, Integer age);
}
