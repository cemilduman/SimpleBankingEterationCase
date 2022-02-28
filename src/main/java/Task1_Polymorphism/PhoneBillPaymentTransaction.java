package Task1_Polymorphism;

public class PhoneBillPaymentTransaction extends BillPaymentTransaction{

    private String phoneNumber;

    public PhoneBillPaymentTransaction(double amount, String payee, String phoneNumber) {
        super(amount);
        this.setPayee(payee);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneBillPaymentTransaction{" +
                "phoneNumber='" + phoneNumber + '\'' +
                super.toString();
    }
}
