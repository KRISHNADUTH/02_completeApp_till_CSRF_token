package com.SpringBootFinalApp.completeApp.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringBootFinalApp.completeApp.model.Customer;
import com.SpringBootFinalApp.completeApp.repository.CustomerRepo;

// Here we are taking authorities from Customer table but When we were using CustomAuthentication provider there authorities were taken from Authority table.
@Service
public class EazyBankUserDetailService implements UserDetailsService {
    
    CustomerRepo customerRepo;

    public EazyBankUserDetailService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepo.findByEmail(username);
        String name, pwd;
        List<GrantedAuthority> authorities= new ArrayList<>();
        if (customers.size()>0) { 
            name = customers.get(0).getEmail();
            pwd = customers.get(0).getPwd();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        } else {
            throw new UsernameNotFoundException("Given email ID is not present in DB");
        }
        System.out.println(name+" "+pwd+" "+authorities);
        return new User(name, pwd, authorities);
    }
    
}
