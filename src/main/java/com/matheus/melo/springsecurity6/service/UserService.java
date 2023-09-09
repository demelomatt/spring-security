package com.matheus.melo.springsecurity6.service;

import com.matheus.melo.springsecurity6.repository.CustomerRepository;
import com.matheus.melo.springsecurity6.model.Customer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public UserService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var customer = customerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the given user"));

        var role = Collections.singletonList(new SimpleGrantedAuthority(customer.getRole()));
        return new User(customer.getEmail(), customer.getPwd(), role);
    }

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
