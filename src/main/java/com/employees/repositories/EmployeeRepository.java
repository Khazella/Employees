package com.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employees.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	String Sequence = "SELECT employee_id " + "FROM employee " + "ORDER BY employee_id DESC " 
	+ "LIMIT 1";
	
	@Query(value = Sequence, nativeQuery = true)
	public int sequenceData();

}
