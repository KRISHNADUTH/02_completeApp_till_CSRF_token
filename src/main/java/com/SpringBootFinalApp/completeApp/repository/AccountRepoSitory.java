package com.SpringBootFinalApp.completeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootFinalApp.completeApp.model.Account;

@Repository
public interface AccountRepoSitory extends JpaRepository<Account, Long>{
    Account findByCustomerId(Long id);
}
