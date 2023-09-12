package com.matheus.melo.springsecurity6.repository;

import com.matheus.melo.springsecurity6.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<Card, Long> {
	
	List<Card> findByCustomerId(int customerId);

}
