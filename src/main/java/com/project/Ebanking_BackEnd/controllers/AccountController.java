package com.project.Ebanking_BackEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Ebanking_BackEnd.models.Compte;
import com.project.Ebanking_BackEnd.services.AccountService;

 

@RestController
@RequestMapping("/api/agent")
public class AccountController {
	
	@Autowired
	AccountService serv;
	
	@GetMapping(value="/id/{id}")
	public Compte finde(@PathVariable int id) {
		return serv.find(id);
		
		
		
	}
	
}
