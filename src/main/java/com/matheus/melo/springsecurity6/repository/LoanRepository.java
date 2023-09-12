package com.matheus.melo.springsecurity6.repository;

import com.matheus.melo.springsecurity6.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);

}
