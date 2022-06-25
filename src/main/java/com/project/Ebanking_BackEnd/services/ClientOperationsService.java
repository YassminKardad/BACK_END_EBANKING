package com.project.Ebanking_BackEnd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Ebanking_BackEnd.models.AccountOperation;
import com.project.Ebanking_BackEnd.repository.AccountOperationRepository;

@Service
public class ClientOperationsService  {

	@Autowired
	AccountOperationRepository serv;
	
	public List<AccountOperation> find(int id){
		return serv.findByBankAccountId(id);
	}
	
	
}
