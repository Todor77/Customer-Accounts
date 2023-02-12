package api.customers.entity;

public class Transaction {

    private String transactionId;
    private String description;
    private double amount;
    private TransactionType transactionType;

    public Transaction(String transactionId, String description, double amount, TransactionType transactionType) {
        this.transactionId = transactionId;
        this.description = description;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}

