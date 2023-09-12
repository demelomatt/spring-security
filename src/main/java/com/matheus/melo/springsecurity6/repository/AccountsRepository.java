package com.matheus.melo.springsecurity6.repository;

import com.matheus.melo.springsecurity6.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

	Account findByCustomerId(int customerId);

}
