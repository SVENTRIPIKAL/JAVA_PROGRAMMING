package exercises.CLASSES_OBJECTS_METHODS.BANK;

import exercises.CLASSES_OBJECTS_METHODS.BANK_CUSTOMER.Account;
import exercises.CLASSES_OBJECTS_METHODS.BANK_CUSTOMER.Customer;

//#8
public class Bank {
    private BankManager bankManager;
    private Customer customer;
    private final Vault vault;
    private Account account;
    
    public Bank(BankManager bankManager, Customer customer, Vault vault) {
        this.bankManager = bankManager;
        this.customer = customer;
        this.vault = vault;
    }
    
    public BankManager getBankManager() {
        return bankManager;
    }
    
    protected void setBankManager(BankManager bankManager) {
        this.bankManager = bankManager;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    protected void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Account getAccount() {
        return account;
    }
    
    protected void setAccount(Account account) {
        this.account = account;
    }
    
    
    @Override
    public String toString() {
        return "Bank{" +
                "bankManager=" + bankManager +
                ", customer=" + customer +
                ", vault=" + vault +
                '}';
    }
}
