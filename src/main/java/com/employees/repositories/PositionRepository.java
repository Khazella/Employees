package com.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employees.models.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

}
