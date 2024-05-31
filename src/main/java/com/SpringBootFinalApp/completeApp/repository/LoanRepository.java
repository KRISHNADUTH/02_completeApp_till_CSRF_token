package com.SpringBootFinalApp.completeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringBootFinalApp.completeApp.model.Loans;

public interface LoanRepository extends JpaRepository<Loans,Integer>{

    List<Loans> findByCustomerIdOrderByStartDtDesc(int id);

}
