package com.project.Ebanking_BackEnd.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ebanking_BackEnd.exceptions.BalanceNotSufficientException;
import com.project.Ebanking_BackEnd.exceptions.BankAccountNotFoundException;
import com.project.Ebanking_BackEnd.models.AccountOperation;

/*@Repository
public interface clientOperationRepository extends JpaRepository<AccountOperation,Long> {
	 List<AccountOperation> findByBankId(Long accountId);
 	//List<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable );
}      
*/

