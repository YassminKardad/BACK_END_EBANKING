package com.project.Ebanking_BackEnd.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Ebanking_BackEnd.models.AccountOperation;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
  List<AccountOperation> findByBankAccountId(String accountId);
}
