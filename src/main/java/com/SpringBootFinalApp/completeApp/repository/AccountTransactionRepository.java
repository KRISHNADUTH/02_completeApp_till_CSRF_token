package com.SpringBootFinalApp.completeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootFinalApp.completeApp.model.AccountTransactions;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransactions,String> {

    public List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(Integer id);

}
