package exercises.more_oop;

import exercises.more_oop.games.chess.*;
import static exercises.more_oop.DaysOfTheWeek.*;

public class Main {
    public static void main(String[] args) {
        //#1    FIRST/MID LETTER CAPITALIZED
        outputDaysTitledMidCased();

        //#1    TEN RANDOM DAYS
        outputTenRandomDays();

        //#2    MEAL LIST
        outputMealList();

        //#3    MEALS FOR DAYS
        getMealsForDays("friday, thursday, monday, saturday, tuesday");

        //#4    NUMERIC POSITION
        outputNumericPosition("l");

        //#5    ALPHABETIC POSITION
        outputAlphabeticValue("12");
        
        //#6-8  CHESS
        Chess.play();
    }
}
