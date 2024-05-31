package com.SpringBootFinalApp.completeApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long customerId;
    @Id
    private Integer accountNumber;
    private String accountType;
    private String branchAddress;
    private String createDt;
}
