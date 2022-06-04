package NUMBERS;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 13; i++) {
            if (i % 3 == 0) { System.out.println(); }
            System.out.printf("%s\t\t",Names.next());
            Names.increment();
        } System.out.printf("%n%n");
        
        for (int i = 0; i < 366; i++) {
            System.out.printf("""
                Code: %s    Days: %s
                """,
                Warehouse.next(i), i
            );
        } System.out.println();
        
        for (int i = 0; i < 12; i++) {
            System.out.println(Rndm.next());
            Rndm.increment();
        } System.out.println();
    }
    
    //#3    ARRAY OF NAMES
    private static final class Names {
        private static int index = 0;
        private static final String[] names = {
                "john", "jaCob", "jingle", "heimer", "smith",
                "dave", "dan", "bobby", "loise", "nick"
        };
        
        private Names() {   }
        
        public static String next() {
            return names[index].substring(0,1).toUpperCase() +
                names[index].substring(1).toLowerCase();
        }
        
        public static void increment() {
            index = index == names.length-1 ? 0 : index +1;
        }
    }
    
    //#4    WAREHOUSE ITEM SHELF-LIFE CODES
    private static final class Warehouse {
        private Warehouse() {    }
        
        public static int next(int age) {
            int x;
            if      (age <= 89)     { x = 0; }
            else if (age <= 179)    { x = 1; }
            else if (age <= 269)    { x = 2; }
            else if (age <= 364)    { x = 3; }
            else                    { x = -1;}
            return x;
        }
    }
    
    //#5    SUM OF 10 RANDOM NUMBERS
    private static final class Rndm {
        private static int sum = 0;
        private static int count = 0;
        private static final Random random = new Random();
        
        private Rndm() {    }
        
        public static int next() {
            if (count != 10) {
                sum += random.nextInt(1, 10);
            }
            return sum;
        }
    
        public static void increment() {
            count = count == 10 ? count : count+1;
        }
    }
}
