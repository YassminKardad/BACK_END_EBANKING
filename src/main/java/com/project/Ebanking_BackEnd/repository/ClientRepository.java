package com.project.Ebanking_BackEnd.repository;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ebanking_BackEnd.models.Agent;
import com.project.Ebanking_BackEnd.models.Client;
import com.project.Ebanking_BackEnd.models.User;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>  {
	Optional<Client> findByEmail(String email);

	boolean existsByEmail(String email);


}
