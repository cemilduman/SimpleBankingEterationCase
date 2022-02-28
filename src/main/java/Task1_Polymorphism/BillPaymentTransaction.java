package Task1_Polymorphism;

public class BillPaymentTransaction extends WithdrawalTransaction{

    private String payee;

    public BillPaymentTransaction(double amount) {
        super(amount);
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    @Override
    public String toString() {
        return  "payee='" + payee + '\'' +
                 super.toString();
    }
}
