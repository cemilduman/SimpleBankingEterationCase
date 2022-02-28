package Task1_Polymorphism.test;


import Task1_Polymorphism.Account;
import Task1_Polymorphism.DepositTransaction;
import Task1_Polymorphism.PhoneBillPaymentTransaction;
import Task1_Polymorphism.WithdrawalTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void  accountTest(){
        Account account = new Account("Jim","123456");
        account.post(new DepositTransaction(1000));
        account.post(new WithdrawalTransaction(200));
        account.post(new PhoneBillPaymentTransaction(96.50,"Vodafone", "5423345566"));
        assertEquals(account.getBalance(), 703.50, 0.0001);

    }
}