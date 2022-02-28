package Task1_Polymorphism;

public class DepositTransaction extends Transaction{

    public DepositTransaction(double amount) {
        super(amount);
        this.setType("Deposit Transaction");
    }
}
