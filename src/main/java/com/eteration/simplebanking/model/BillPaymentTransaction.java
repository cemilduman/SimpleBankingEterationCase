package com.eteration.simplebanking.model;

import lombok.*;

@Getter
@Setter
public abstract class BillPaymentTransaction extends Transaction{

    private String payee;

    protected BillPaymentTransaction(double amount) {
        super(amount);
    }
}
