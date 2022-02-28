package com.eteration.simplebanking.model;

public class CheckTransaction extends BillPaymentTransaction{

    private String checkNumber;

    public CheckTransaction(double amount,String payee, String checkNumber) {
        super(amount);
        this.setType("CheckTransaction");
        this.setPayee(payee);
        this.checkNumber = checkNumber;
    }
}
