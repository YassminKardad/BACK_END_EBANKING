package com.project.Ebanking_BackEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Ebanking_BackEnd.models.Compte;
import com.project.Ebanking_BackEnd.repository.BankAccountRepository;

@Service
public class AccountService {
     
	 @Autowired
     BankAccountRepository bank;
	
	 
	 public Compte find(int Id) {
	 	 
	 	 return bank.findByCustomerId(Id);
	 }
	 
}
