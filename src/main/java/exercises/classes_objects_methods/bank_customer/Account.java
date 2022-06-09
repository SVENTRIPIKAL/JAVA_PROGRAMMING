package exercises.classes_objects_methods.bank_customer;

//#8
public class Account {
    private int accountNumber;
    private int accountTotal;
    
    public Account(int accountNumber, int initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountTotal = initialDeposit;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    protected void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public int getAccountTotal() {
        return accountTotal;
    }
    
    protected void setAccountTotal(int accountTotal) {
        this.accountTotal = accountTotal;
    }
    
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountTotal=" + accountTotal +
                '}';
    }
}
