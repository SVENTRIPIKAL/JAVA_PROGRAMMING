package methods.strings.parsing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Parsed {
    private Parsed() {    }
    
    public static Object returnObjectFromInfo(String info) {
        String regex = "(?<firstName>[\\w\\s]+),.?" +
                        "(?<lastName>[\\w\\s]+),.?" +
                        "(?<street>[\\w\\d\\s.]*),.?" +
                        "(?<city>[\\w\\s]+),.?" +
                        "(?<state>\\w+|\\w{2}),.?" +
                        "(?<zip>\\w{5}(-\\d{4})?)";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(info);
        if (mat.find()) {
            return new Person(
                    mat.group("firstName"),
                    mat.group("lastName"),
                    mat.group("street"),
                    mat.group("city"),
                    mat.group("state"),
                    mat.group("zip")
            );
        } else { return null; }
    }
}
