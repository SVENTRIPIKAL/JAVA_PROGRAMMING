package exercises.CONTROL_FLOW;

import static CONTROL_FLOW.Functions.outputDaysOfWeek;
import static CONTROL_FLOW.Functions.outputAddressInfo;

public class Main {
    public static void main(String[] args) {
        //#1    DAYS OF THE WEEK (FOR-LOOP)
        outputDaysOfWeek("for");
        
        //#2    DAYS OF THE WEEK (WHILE-LOOP)
        outputDaysOfWeek("while");
    
        //#3    DAYS OF THE WEEK (DO-WHILE)
        outputDaysOfWeek("do-while");
        
        //#4-6  DAYS OF THE WEEK (MEAL TABLE)
        outputDaysOfWeek("meals");
    
        //#7    DAYS OF THE WEEK (TOTAL CHARACTERS)
        outputDaysOfWeek("total-chars");
        
        //#7    DAYS OF THE WEEK (DEFAULT)
        outputDaysOfWeek("default");
        
        //#8    PARSING ADDRESS INFO
        outputAddressInfo();
    }
}
