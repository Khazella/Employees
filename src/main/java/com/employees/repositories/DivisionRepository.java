package com.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employees.models.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {

}
