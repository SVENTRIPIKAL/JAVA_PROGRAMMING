package CLASSES_OBJECTS_METHODS.BANK;

//#8
public class BankManager {
    private Vault vault;
    
    public BankManager(Vault vault) {
        this.vault = vault;
    }
    
    public Vault getVault() {
        return vault;
    }
    
    public void enterVault() {
    
    }
    
    protected void setVault(Vault vault) {
        this.vault = vault;
    }
    
    @Override
    public String toString() {
        return "BankManager{" +
                "vault=" + vault +
                '}';
    }
}
