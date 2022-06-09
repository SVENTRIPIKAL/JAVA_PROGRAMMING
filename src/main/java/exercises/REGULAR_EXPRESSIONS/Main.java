package exercises.REGULAR_EXPRESSIONS;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        //#1    PARSING ARK
        String myString = "Dark,bark    ,Stark    Lark, " +
                "mark,  part    mart    parlor, start   stark";
        Parse.text(myString);
        
        //#2    PARSING BRA & GRA
        String braGra = "Abracadabra      Agracadagra";
        Parse.abracadabra(braGra);
        
        //#4    PHYSICAL ADDRESS CHECKER
        String physical = "1964 N JACKSON RD., TALLAHASSEE, TX 78961";
        String poBox = "PO BOX 1335, AUSTIN, TX   78509";
        System.out.printf("%s%n%n", Parse.checkAddress(physical));
        
        //#5    EMAIL ADDRESS CHECKER
        String email = "#1Andy%_$Woods+956!@hotmail.net";
        String nonEmail = "12345@gmail.com";
        System.out.println(Parse.checkEmail(email));
    }
    
    
    //#1-5    PARSING UTILITY CLASS VIA REGEX
    private static final class Parse {
        private Parse() {   }
        
        public static void text(String text) {
            String regex = "[dDbBlLsS](t)?ark";
            Pattern pat = Pattern.compile(regex);
            Matcher mat = pat.matcher(text);
            while (mat.find()) {
                System.out.printf("%s\t", mat.group());
            }
            System.out.print("\n\n");
        }
    
        public static void abracadabra(String abracadabra) {
            String regex = "(?<braGra>[bBgG]ra)";
            Pattern pat = Pattern.compile(regex);
            Matcher mat = pat.matcher(abracadabra);
            while (mat.find()) {
                System.out.printf("%s\t\t", mat.group("braGra"));
            }
            System.out.print("\n\n");
        }
    
        public static boolean checkAddress(String address) {
            String regex =
                "((?<street>\\d+(([\\s\\t]+)\\w+[.]?)+),.?)" +
                "((?<city>\\w{3,}),.?)" +
                "((?<state>\\w{2}).?)" +
                "(?<zipCode>\\d{5}(-\\d{4})?)";
            Pattern pat = Pattern.compile(regex);
            Matcher mat = pat.matcher(address);
            if (mat.find()) {
                System.out.printf("""
                    Street: %s
                    City:   %s
                    State:  %s
                    Zip:    %s
                    """, mat.group("street"),
                    mat.group("city"),
                    mat.group("state"),
                    mat.group("zipCode")
                );
                return true;
            } else { return false; }
        }
    
        public static boolean checkEmail(String email) {
            String regex = "(?<email>((.+)?\\p{Alpha}+\\d*(.+)?)+" +
                    "@\\p{Alpha}+[.](com|net|gov|org))";
            Pattern pat = Pattern.compile(regex);
            Matcher mat = pat.matcher(email);
            if (mat.find()) {
                System.out.printf("%s%n", mat.group("email"));
                return true;
            } else { return false; }
        }
    }
}
