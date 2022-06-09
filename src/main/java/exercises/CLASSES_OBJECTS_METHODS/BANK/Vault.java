package exercises.CLASSES_OBJECTS_METHODS.BANK;

//#8
public class Vault {
    private final int money;
    
    public Vault(int money) {
        this.money = money;
    }
    
    @Override
    public String toString() {
        return "Vault{" +
                "money=" + money +
                '}';
    }
}
