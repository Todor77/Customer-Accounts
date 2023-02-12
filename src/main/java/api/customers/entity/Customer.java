package api.customers.entity;

public class Customer {

    private int customerId;
    private String name;
    private int initialCredit;
    private Account account;

    public Customer() {
    }

    public Customer(int customerId, String name, int initialCredit) {
        this.customerId = customerId;
        this.name = name;
        this.initialCredit = initialCredit;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public int getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(int initialCredit) {
        this.initialCredit = initialCredit;
    }
}
