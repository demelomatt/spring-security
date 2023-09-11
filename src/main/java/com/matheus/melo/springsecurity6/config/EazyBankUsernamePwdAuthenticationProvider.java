package com.matheus.melo.springsecurity6.config;

import com.matheus.melo.springsecurity6.repository.CustomerRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public EazyBankUsernamePwdAuthenticationProvider(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var email = authentication.getName();
        var pwd = authentication.getCredentials().toString();
        var customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("User details not found for the given user"));

        if (passwordEncoder.matches(pwd, customer.getPwd())) {
            var role = Collections.singletonList(new SimpleGrantedAuthority(customer.getRole()));
            return new UsernamePasswordAuthenticationToken(email, pwd, role);
        }

        throw  new BadCredentialsException ("User details not found for the given user");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
