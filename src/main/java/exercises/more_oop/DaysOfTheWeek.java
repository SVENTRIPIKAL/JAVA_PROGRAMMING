package exercises.more_oop;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import methods.strings.casing.Cased;

public enum DaysOfTheWeek {
    MONDAY("spaghetti"),
    TUESDAY("tacos"),
    WEDNESDAY("chicken"),
    THURSDAY("meatloaf"),
    FRIDAY("hamburgers"),
    SATURDAY("pizza"),
    SUNDAY("pot roast");
    
    private static final ArrayList<DaysOfTheWeek> list = new ArrayList<>(
            Arrays.asList(DaysOfTheWeek.values())
    );
    private final String food;
    
    DaysOfTheWeek(String food) {
        this.food = food;
    }
    
    //#1    FIRST/MID LETTER CAPITALIZED
    public static void outputDaysTitledMidCased() {
        for (DaysOfTheWeek day : list) {
            System.out.printf("""
                %-10s | %10s
                """, Cased.toTitleCase(day.name()),
                Cased.returnMidCased(day.name()));
        }   System.out.println();
    }
    
    //#1    TEN RANDOM DAYS
    public static void outputTenRandomDays() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(list.size());
            System.out.printf("\t#%-2d\t%-2s%n", i+1, list.get(num).name());
        }   System.out.println();
    }
    
    //#2    MEAL LIST
    public static void outputMealList() {
        for (DaysOfTheWeek day : list) {
            System.out.printf("""
                We eat %s on %s.
                """, Cased.toTitleCase(day.toString()),
                Cased.toTitleCase(day.name())
            );
        }   System.out.println();
    }
    
    //#3    MEALS FOR DAYS
    public static void getMealsForDays(String stringOfDays) {
        String[] days = stringOfDays.toUpperCase()
                .replace(" ", "")
                .split(",");
        StringBuilder sb = new StringBuilder();
        for (String day : days) {
            sb.append(Cased.toTitleCase(
                    DaysOfTheWeek.valueOf(day).toString())
            );
            if (!day.equals(days[days.length - 1])) {
                sb.append(", ");
            }
        }   System.out.println(sb);
    }
    
    //#4    ALPHABETICAL POSITION
    
    
    @Override public String toString() {
        return this.food;
    }
}
