package com.project.Ebanking_BackEnd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ebanking_BackEnd.models.Agent;



@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer>  {
	 // Query method
    Optional<Agent> findByEmail(String email);

	boolean existsByEmail(String email);
}