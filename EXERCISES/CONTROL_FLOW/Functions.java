package CONTROL_FLOW;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Functions {
    private Functions() {   }
    
    //#1-7  DAYS OF THE WEEK
    protected static void outputDaysOfWeek(String loop) {
        ArrayList<String> daysOfTheWeek = new ArrayList<>(Arrays.asList(
                "monday", "tuesday", "wednesday",
                "thursday", "friday", "saturday",
                "sunday"
        ));
        switch (loop.toLowerCase()) {
            case ("for") -> printAsForLoop(daysOfTheWeek);
            
            case ("while") -> printAsWhileLoop(daysOfTheWeek);
            
            case ("do-while") -> printAsDoWhileLoop(daysOfTheWeek);
            
            case ("meals") ->  printAsMealLoop(daysOfTheWeek);
            
            case ("total-chars") -> printAsTotalChars(daysOfTheWeek);
            
            default -> printAsDefaultCase(daysOfTheWeek);
        }
    }
    
    //#8    PARSING ADDRESS INFO
    protected static void outputAddressInfo() {
        String addresses = """
            12345 First Street, First City, AA 90210
            22222 Second Street, Second City, BB 22222
            33333 Third Street, Third City, CC 33333
            44444 Fourth Street, Fourth City, DD 44444
            55555 Fifth Street, Fifth City, EE 55555
            66666 Sixth Street, Sixth City, FF 66666
            77777 Seventh Street, Seventh City, GG 77777
            88888 Eighth Street, Eighth City, HH 88888
            99999 Ninth Street, Ninth City, II 99999
            00000 Tenth Street, Tenth City, JJ 00000
            """;
        String regex =  "(?<street>\\d{5}[\\w\\s]+),.?" +
                        "(?<city>[\\w\\s]+),.?" +
                        "(?<state>\\w{2}).?" +
                        "(?<zip>\\d{5})";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(addresses);
        int count = 1;
        while (mat.find()) {
            System.out.printf("""
                \t[ADDRESS #%s]:
                Street: %s
                City:   %s
                State:  %s
                Zip:    %s%n
                """, count, mat.group("street"), mat.group("city"),
                mat.group("state"), mat.group("zip")
            ); count++;
        }
    }
    
    // OUTPUTS DAYS OF THE WEEK WITH A FOR LOOP
    private static void printAsForLoop(ArrayList<String> daysOfTheWeek) {
        System.out.printf("%18s%n", "[FOR-LOOP]");
        for (String day : daysOfTheWeek) {
            System.out.printf("%-10s", toTitleCase(day));
            if (daysOfTheWeek.indexOf(day) % 2 == 0) {
                System.out.printf("\t|\t%10s%n", day.toUpperCase());
            } else { System.out.println(); }
        } System.out.printf("%n");
    }
    
    // OUTPUTS DAYS OF THE WEEK WITH A WHILE LOOP
    private static void printAsWhileLoop(ArrayList<String> daysOfTheWeek) {
        System.out.printf("%18s%n", "[WHILE-LOOP]");
        int index = 0;
        while (index < daysOfTheWeek.size()) {
            String day = daysOfTheWeek.get(index);
            System.out.printf("%-10s", toTitleCase(day));
            if (daysOfTheWeek.indexOf(day) % 2 != 0) {
                System.out.printf("\t|\t%10s%n", day.toUpperCase());
            } else { System.out.println(); }
            index++;
        } System.out.printf("%n");
    }
    
    // OUTPUTS DAYS OF THE WEEK WITH A DO-WHILE LOOP
    private static void printAsDoWhileLoop(ArrayList<String> daysOfTheWeek) {
        System.out.printf("%20s%n", "[DO-WHILE-LOOP]");
        Random random = new Random();
        int num = random.nextInt(daysOfTheWeek.size());
        int index = 0;
        do {
            String day = daysOfTheWeek.get(index);
            System.out.printf("%-10s", toTitleCase(day));
            if (daysOfTheWeek.indexOf(day) == num) {
                System.out.printf("\t|\t%10s%n", day.toUpperCase());
            } else { System.out.printf("\t->\t%10s%n", day); }
            index++;
        } while (index < daysOfTheWeek.size());
        System.out.printf("%n");
    }
    
    // OUTPUTS A MEAL TABLE FOR EACH DAY OF THE WEEK
    private static void printAsMealLoop(ArrayList<String> daysOfTheWeek) {
        System.out.printf("%18s%n", "[MEAL-LOOP]");
        String meal;
        for (String days : daysOfTheWeek) {
            switch (days) {
                case ("sunday") ->      meal = "pot roast";
                case ("monday") ->      meal = "spaghetti";
                case ("tuesday") ->     meal = "tacos";
                case ("wednesday") ->   meal = "chicken";
                case ("thursday") ->    meal = "meatloaf";
                case ("friday") ->      meal = "hamburgers";
                case ("saturday") ->    meal = "pizza";
                default ->              meal = "nothing";
            } System.out.printf("\"We eat %s on %s.\"%n",
                    toTitleCase(meal), toTitleCase(days));
        } System.out.println();
    }
    
    // OUTPUTS THE SUM OF ALL STRING SIZES FOR EACH DAY OF THE WEEK
    private static void printAsTotalChars(ArrayList<String> daysOfTheWeek) {
        int total = 0;
        for (String days : daysOfTheWeek) {
            total += days.length();
        } System.out.printf("TOTAL CHARACTERS IN WEEK:   %s%n", total);
    }
    
    // OUTPUTS THE DAYS OF THE WEEK AS AN ARRAY
    private static void printAsDefaultCase(ArrayList<String> daysOfTheWeek) {
        System.out.printf("DEFAULT PRINT: %s%n%n",
                Arrays.toString(daysOfTheWeek.toArray()).toUpperCase()
        );
    }
    
    // RETURNS COMPLETE STRING WITH ALL FIRST LETTERS CAPITALIZED
    private static String toTitleCase(String text) {
        String regex = "\\p{Alpha}+([\\s\\t]|\\b)+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(text);
        StringBuilder casing = new StringBuilder();
        while (mat.find()) {
            casing.append(mat.group().substring(0,1).toUpperCase())
                    .append(mat.group().substring(1));
        } return casing.toString();
    }
}
