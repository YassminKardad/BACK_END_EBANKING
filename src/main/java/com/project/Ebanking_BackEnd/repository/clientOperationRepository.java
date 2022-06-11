package com.project.Ebanking_BackEnd.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Ebanking_BackEnd.exceptions.BalanceNotSufficientException;
import com.project.Ebanking_BackEnd.exceptions.BankAccountNotFoundException;
import com.project.Ebanking_BackEnd.models.AccountOperation;

public interface clientOperationRepository extends JpaRepository<AccountOperation,Long> {
	public List<AccountOperation> findByBankAccountId(String accountId)throws BankAccountNotFoundException;
 	//List<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable );
      

}
