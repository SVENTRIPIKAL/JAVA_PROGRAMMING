package exercises.more_oop;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import methods.strings.casing.Cased;

public class Main {
    public static void main(String[] args) {
        //#1    ENUMS - FIRST/MID LETTER CAPITALIZED & RANDOM
        Random random = new Random();
        int num = random.nextInt(DaysOfTheWeek.values().length);
        for (DaysOfTheWeek day : DaysOfTheWeek.values()) {
            System.out.printf("""
                %-10s | %10s
                """, Cased.toTitleCase(day.toString()),
                Cased.returnMidCased(day.toString()));
        }
        ArrayList<DaysOfTheWeek> list = new ArrayList<>(
                Arrays.asList(DaysOfTheWeek.values())
        );
        System.out.printf("%15s%n", list.get(num));
        
        //#2    ENUM MEAL GRAPH
        
    }
}
