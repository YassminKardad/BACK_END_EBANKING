package com.project.Ebanking_BackEnd.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Ebanking_BackEnd.models.Compte;

public interface BankAccountRepository extends JpaRepository<Compte,String> {
}