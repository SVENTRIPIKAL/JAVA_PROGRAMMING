package WORKING_WITH_TEXT;

public class Main {
    public static void main(String[] args) {
        //#1    STORING UPPER-CASED NAMES
        Person person = new Person("john", "smith");
        System.out.printf("%s%n%n", person);
        
        //#2    REPLACING "CAT(S)" WITH "DOG(S)"
        String cat_sentence = """
            There were so many CATS in the town
            of Cat-N-Ville, that every person
            living there practically had a cAT
            of their own.
            """;
        System.out.println(replaceAllCats(cat_sentence));
        
        //#3    RIDDING OF UNNECESSARY WHITE-SPACES
        String messedUpString = """
                This string     is not
            spaced      out     properly    .
            """;
        System.out.println(messedUpString);
        System.out.println(fixString(messedUpString));
        
        //#4    ALTERING INPUT
        System.out.println(alphabeT());
    
        //#5    PARSING AN ADDRESS BY SECTION
        String address = "12345 Big St., Alphabet City, CA 90210";
        Parse.addressFormatted(address);
    }
    
    
    //#1    PERSON CLASS (STORES UPPER-CASED NAMES)
    private record Person(String firstName, String lastName) {
        private Person(String firstName, String lastName) {
            this.firstName = firstName.toUpperCase();
            this.lastName = lastName.toUpperCase();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
    
    //#2    METHOD REPLACES "CAT(S)" WITH "DOG(S)"
    private static String replaceAllCats(String text) {
        text = text.replaceAll("[cC][aA][tT]", "Dog");
        return text.replaceAll("\\p{Alpha}{3}S", "Dogs");
    }
    
    //#3    METHOD REMOVES EXCESS WHITE-SPACE
    private static String fixString(String messedUpString) {
        return messedUpString.strip()
                .replaceAll("[ \t]+", " ")
                .replace("not", "now")
                .replace(" .", ".\n");
    }
    
    //#4    METHOD REMOVES EXCESS WHITE-SPACE & UPPER-CASES 'T'
    private static String alphabeT() {
        return String.format("""
            %s
            """,
            "   alphabet ".strip()
            .replace("t", "T"));
    }
    
    //#5    PARSING UTILITY CLASS (CONTAINS METHODS)
    private final static class Parse {
        private Parse() {   }
        
        public static String buildingNumber(String address) {
            String[] sections = address.split(",");
            sections = sections[0].split(" ");
            return sections[0].strip();
        }
        
        public static String streetName(String address) {
            String[] sections = address.split(",");
            int indexSpace = sections[0].indexOf(" ") + 1;
            return sections[0].substring(indexSpace).strip();
        }
    
        public static String city(String address) {
            String[] sections = address.split(",");
            return sections[1].strip();
        }
    
        public static String state(String address) {
            String[] sections = address.split(",");
            sections = sections[2].strip().split(" ");
            return sections[0];
        }
    
        public static String postalCode(String address) {
            String[] sections = address.split(",");
            sections = sections[2].strip().split(" ");
            return sections[1];
        }
        
        public static void addressFormatted(String address) {
            System.out.printf("""
                Building Number:    %s
                Street Name:        %s
                City:               %s
                State:              %s
                Postal Code:        %s
                """, Parse.buildingNumber(address),
                Parse.streetName(address),
                Parse.city(address),
                Parse.state(address),
                Parse.postalCode(address)
            );
        }
    }
}