package exercises.classes_objects_methods.bank_customer;

//#8
public class Customer {
    private String name;
    private Account checkingAccount;
    private int initialDeposit;
    private int wallet;
    
    public Customer(String name, int initialDeposit) {
        this.name = name;
        this.checkingAccount = new Account(9856719,
                initialDeposit);
        this.initialDeposit = initialDeposit;
        this.wallet = 500;
    }
    
    public String getName() {
        return name;
    }
    
    protected void setName(String name) {
        this.name = name;
    }
    
    public int getInitialDeposit() {
        return initialDeposit;
    }
    
    protected void setInitialDeposit(int initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
    
    public Account getCheckingAccount() {
        return checkingAccount;
    }
    
    protected void setCheckingAccount(Account checkingAccount) {
        this.checkingAccount = checkingAccount;
    }
    
    public void depositMoney(int money) {
        if (!(wallet - money < 0)) {
            int acctTotal = getCheckingAccount().getAccountTotal();
            
            getCheckingAccount().setAccountTotal(
                    acctTotal + money
            );
            wallet -= money;
        } else {
            System.out.println("Not enough funds in your wallet.");
        }
    }
    
    public void withdrawMoney(int money) {
        int acctTotal = getCheckingAccount().getAccountTotal();
        
        if (!(acctTotal - money <= 0)) {
            getCheckingAccount().setAccountTotal(
                    acctTotal -= money
            );
            wallet += money;
        } else {
            System.out.println("Need to leave at least $1 in account.");
        }
    }
    
    
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", checkingAccount=" + checkingAccount +
                ", initialDeposit=" + initialDeposit +
                ", wallet=" + wallet +
                '}';
    }
}
