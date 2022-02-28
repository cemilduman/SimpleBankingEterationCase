package Task1_Polymorphism;

import java.util.Date;

public abstract class Transaction {
    private Date date = new Date(System.currentTimeMillis());
    private double amount;
    private String type;
    private String approvalCode;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "date=" + date +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", approvalCode='" + approvalCode + '\'' +
                '}';
    }
}
