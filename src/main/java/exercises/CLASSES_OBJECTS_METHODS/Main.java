package exercises.CLASSES_OBJECTS_METHODS;

import exercises.CLASSES_OBJECTS_METHODS.BANK.Bank;
import exercises.CLASSES_OBJECTS_METHODS.BANK.BankManager;
import exercises.CLASSES_OBJECTS_METHODS.BANK.Vault;
import exercises.CLASSES_OBJECTS_METHODS.BANK_CUSTOMER.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //#2 - 2.1
        String[] dow = {"Monday", "Tuesday", "Wednesday", "Thursday",
                        "Friday", "Saturday", "Sunday"};
        System.out.println(dow.length);
        System.out.println(dow[3]);
        System.out.println();
        
        //#3
        int[] nums = new int[10];
        for (int i = 1; i <= 10; i++){
            int x = i - 1 ;
            nums[x] = i ;
        } System.out.println(Arrays.toString(nums));
        System.out.println();
        
        //#4
        char[][] ticTacToe = {{'O', 'X', 'X'}, {'X', 'O', 'O'}, {'X', 'O', 'O'}};
        for (char[] chars : ticTacToe) {
            for (int x = 0; x < ticTacToe.length; x++) {
                System.out.print(chars[x]);
            }
            System.out.println();
        }
        System.out.format("Bottom Right Square: '%s'%n", ticTacToe[2][2]);
        System.out.println();
        
        //#5
        print("today", "was", "hot");
        System.out.println();
        
        //#7
        Car newCar = new Car("Honda",
            "Accord",
            LocalDate.ofYearDay(2012,1)
        ); System.out.println(newCar);
        System.out.println();
        
        //#8 - 9
        Vault vault = new Vault(500_000);
        BankManager bankManager = new BankManager(vault);
        Customer customer = new Customer("helen", 500);
        Bank bank = new Bank(bankManager, customer, vault);
        System.out.println(bank);
        System.out.println();
        
        //#10
        System.out.println(Math.EULERS_NUMBER);
        System.out.println();
        
        //#11
        System.out.println(Arrays.toString(
                Friends.Names.values())
        );
    }
    
    
    //#5    VARARGS METHOD
    private static void print(String...text) {
        for (String x : text) {
            System.out.format("%s ", x.toUpperCase());
        }
        System.out.println();
    }
    
    //#7    CLASS AS RECORD
    private record Car(String make, String model, LocalDate year) {
        static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(
                "yyyy", Locale.ENGLISH
        );
        
        @Override
        public String toString() {
            return String.format("""
                Car = {Make: %s\tModel: %s\tYear: %s}""",
                make.toUpperCase(),
                model.toUpperCase(), dtf.format(year)
            );
        }
    }
    
    //#10   UTILITY CLASS
    private final static class Math {
        public static final double EULERS_NUMBER = 2.71828;
        
        private Math() {    }
    }
    
    //#11   CLASS WITH ORDINAL ENUMERATOR
    private static class Friends {
        enum Names {
            JOHN, JILL, JAY
        }
    }
}
