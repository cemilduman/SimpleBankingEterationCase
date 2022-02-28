package Task1_Polymorphism;

public class WithdrawalTransaction extends Transaction{

    public WithdrawalTransaction(double amount) {
        super(amount);
        this.setType("Withdrawal Transaction");
    }

    @Override
    public String toString() {
        return "WithdrawalTransaction{ " + super.toString();
    }
}
