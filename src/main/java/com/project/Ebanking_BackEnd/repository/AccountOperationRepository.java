package com.project.Ebanking_BackEnd.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ebanking_BackEnd.models.AccountOperation;

import java.util.List;
@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation,Integer> {
  List<AccountOperation> findByBankAccountId(int accountId);
}
