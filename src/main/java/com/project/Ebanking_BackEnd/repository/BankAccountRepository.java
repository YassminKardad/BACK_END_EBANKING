package com.project.Ebanking_BackEnd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ebanking_BackEnd.models.Compte;

@Repository
public interface BankAccountRepository extends JpaRepository<Compte,String> {
	Compte findByCustomerId(int id);
}