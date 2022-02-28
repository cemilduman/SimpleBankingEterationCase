package com.eteration.simplebanking.repository.entity;

import com.eteration.simplebanking.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Account {
    @Id
    private String id;
    private String owner;
    private String accountNumber;
    private double balance = 0;
    Set<Transaction> transactions = new HashSet<>();
}
