package com.eteration.simplebanking.model;

public class PhoneBillPaymentTransaction extends BillPaymentTransaction{

    private String phoneNumber;

    public PhoneBillPaymentTransaction(double amount,String payee, String phoneNumber) {
        super(amount);
        this.setType("PhoneBillPaymentTransaction");
        this.setPayee(payee);
        this.phoneNumber = phoneNumber;
    }
}
