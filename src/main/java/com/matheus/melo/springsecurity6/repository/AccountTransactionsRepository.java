package com.matheus.melo.springsecurity6.repository;

import com.matheus.melo.springsecurity6.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransaction, Long> {
	
	List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
