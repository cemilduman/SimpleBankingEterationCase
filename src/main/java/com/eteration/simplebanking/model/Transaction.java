package com.eteration.simplebanking.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public abstract class Transaction{
    private String type;
    private double amount;
    private Long date;
    private String approvalCode;
    private int transactionTypeCode;

    protected Transaction(double amount){
        this.amount = amount;
        this.approvalCode = UUID.randomUUID().toString();
        this.date = new Date().getTime();
    }
}
