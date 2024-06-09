package com.SpringBootFinalApp.completeApp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.SpringBootFinalApp.completeApp.model.Authority;
import com.SpringBootFinalApp.completeApp.model.Customer;
import com.SpringBootFinalApp.completeApp.repository.AuthorityRepo;
import com.SpringBootFinalApp.completeApp.repository.CustomerRepo;

// Here we are taking authorities from Authority table but When we were using CustomUserDetailService there authorities were taken from Customer table itself
@Component
public class EazyBankAuthenticationProvider implements AuthenticationProvider{

    CustomerRepo customerRepo;
    PasswordEncoder passwordEncoder;
    AuthorityRepo authorityRepo;
    public EazyBankAuthenticationProvider(CustomerRepo customerRepo,PasswordEncoder passwordEncoder, AuthorityRepo authorityRepo) {
        this.customerRepo = customerRepo;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepo = authorityRepo;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (customerRepo.findByEmail(userName).size() < 1) {
            throw new BadCredentialsException("No users with given credentials!");
        } 
        else {
                Customer customer = customerRepo.findByEmail(userName).get(0);
                String storedPassword = customer.getPwd();
                List<Authority> authorities = authorityRepo.findByCustomerId(customer.getId());
                // Here we are taking authorities from Authority table
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                for (Authority authority : authorities) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
                }
                if (passwordEncoder.matches(password, storedPassword)) {
                    System.out.println("Password matched in EazyBankAuthenticationProvider............");
                    return new UsernamePasswordAuthenticationToken(userName, storedPassword, grantedAuthorities);
                } else {
                    throw new BadCredentialsException("Wrong password");
                }
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
    
}
