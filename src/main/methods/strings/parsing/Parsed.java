package methods.strings.parsing;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Parsed {
    private Parsed() {    }
    
    // RETURNS AN ARRAY OF OBJECT(S) FROM A STRING OF INFORMATION
    public static ArrayList<Object> returnObjectsFromInfo(String info) {
        String regex =  "(?<firstName>[\\w\\s]*)[,\\s]*" +
                        "(?<lastName>[\\w\\s]*)[,\\s]*" +
                        "(?<street>[\\w\\d\\s.]*)[,\\s]*" +
                        "(?<city>[\\w\\s]*)[,\\s]*" +
                        "(?<state>[\\w\\s]*|\\w{2})[,\\s]*" +
                        "(?<zip>\\d{5}(-\\d{4})?)[\\s|]*";
        ArrayList<Object> arrayList = new ArrayList<>();
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(info);
        while (mat.find()) {
            arrayList.add(new Person(
                    mat.group("firstName"),
                    mat.group("lastName"),
                    mat.group("street"),
                    mat.group("city"),
                    mat.group("state"),
                    mat.group("zip")
            ));
        } return arrayList;
    }
}
