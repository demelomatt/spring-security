package com.matheus.melo.springsecurity6.repository;

import com.matheus.melo.springsecurity6.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
