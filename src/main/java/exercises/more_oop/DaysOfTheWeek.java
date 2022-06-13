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
        }   System.out.printf("%s%n%n", sb);
    }
    
    //#4    NUMERIC POSITION
    public static void outputNumericPosition(String letter) {
        if (letter.toLowerCase().matches("(?<letter>[a-z])")) {
            char[] array = letter.toLowerCase().toCharArray();
            int numericPosition = (int) array[0] - 96;
            String alphabeticValue = String.valueOf(array[0]);
            System.out.printf("%-5s | %5s%n%n", alphabeticValue, numericPosition);
        } else System.out.printf("\"NOT A LETTER OF THE ALPHABET!!!\"%n%n");
    }
    
    //#5    ALPHABETICAL POSITION
    public static void outputAlphabeticValue(String numberBetween1_26) {
        if (numberBetween1_26.matches("[1-9]|1\\d|2[0-6]")) {
            int numericPosition = Integer.parseInt(numberBetween1_26);
            int alphabeticValue = numericPosition + 96;
            System.out.printf("%-5s | %5c%n%n",
                numericPosition, (char) alphabeticValue);
        } else System.out.printf("\"NOT A NUMBER BETWEEN 1-26!!!\"%n%n");
    }
    
    //#6    CHESSBOARD COORDINATES
    public static void chessBoardCoordinatesToArray(String chessCoordinates) {
        if (chessCoordinates.toLowerCase().matches("[a-h][1-8]")) {
            int letter = chessCoordinates.toLowerCase().charAt(0) - 97;
            int number = 8 - Integer.parseInt(
                    chessCoordinates.substring(1)
            );
            System.out.printf("[%s, %s]%n%n", letter, number);
        } else System.out.printf("\"CHESS BOARDS ARE ONLY 8x8!!!\"%n%n");
    }
    
    @Override public String toString() {
        return this.food;
    }
}
