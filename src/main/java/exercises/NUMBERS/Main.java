package exercises.NUMBERS;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        //#3    ARRAY OF NAMES
        for (int i = 0; i < 13; i++) {
            if (i % 3 == 0) { System.out.println(); }
            System.out.printf("%s\t\t",Names.next());
            Names.increment();
        } System.out.printf("%n%n");
    
        //#4    WAREHOUSE ITEM SHELF-LIFE CODES
        for (int i = 1; i <= 366; i++) {
            System.out.printf("""
                Code: %s    Days: %s
                """,
                Warehouse.next(i), i
            );
        } System.out.println();
    
        //#5    SUM OF 10 RANDOM NUMBERS
        for (int i = 0; i < 12; i++) {
            System.out.println(Rndm.next());
            Rndm.increment();
        } System.out.println();
    
        //#6    MONEY FORMATTER
        System.out.printf("%s%n%n", formatMoney("149.32"));
    
        //#7    BIG DECIMAL MONEY CALCULATION
        System.out.printf("%s%n%n", calculateMoney("$12,345.83"));
    
        //#8-10 FORMATTING AN INPUT/OUTPUT TABLE
        printInputOutputTable();
    
        //#11   RETURN SUM OF TWO STRING NUMBERS
        System.out.println(sumOfStringNums("37", "13"));
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
            int code = age / 90;
            return Math.min(code, 3);
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
    
    //#6    MONEY FORMATTER
    public static String formatMoney(String money) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(Double.valueOf(money));
    }
    
    //#7    BIG DECIMAL MONEY CALCULATION
    public static String calculateMoney(String money) throws Exception {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        MathContext mc = new MathContext(5);
        
        String parsed = String.valueOf(nf.parse(money));
        BigDecimal bd = new BigDecimal(parsed).divide(
                        new BigDecimal("32.19"), mc
        );
        return nf.format(Double.valueOf(String.valueOf(bd)));
    }
    
    //#8-10 FORMATTING AN INPUT/OUTPUT TABLE
    public static void printInputOutputTable() {
        DecimalFormat moneyFormat = new DecimalFormat("$#,###.##;(#)");
        DecimalFormat decimalFormat = new DecimalFormat("#,###.#;-#");
        DecimalFormat leadingFormat = new DecimalFormat("0000000000");
        DecimalFormat scientificFormat = new DecimalFormat("0.######E00f");
        String[] input = {
                "123456.783", "-9876.32532", "23.19283928394829182",
                "123456",   "-9876.35532"
        };
        System.out.printf("""
            [INPUTS]                            [OUTPUTS]
            %-10s   %24s        $%,(.2f
            %-10s   %22s         %,(.2f
            %-10s   %15s       %.6ef
            %-10s   %23s         %010d
            %-10s   %20s           %,.1f%n
            """, input[0], moneyFormat.format(123456.783),
            Double.valueOf(input[0]),
            input[1], moneyFormat.format(-9876.32532),
            Double.valueOf(input[1]),
            input[2], scientificFormat.format(23.19283928394829182),
            Double.valueOf(input[2]),
            input[3], leadingFormat.format(123456),
            Integer.parseInt(input[3]),
            input[4], decimalFormat.format(-9876.35532),
            Double.valueOf(input[4])
        );
    }
    
    //#11   RETURN SUM OF TWO STRING NUMBERS
    public static int sumOfStringNums(String num1, String num2) {
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }
}
