package methods.strings.casing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Cased {
    private Cased() {   }
    
    // RETURNS STRING WITH EVERY OTHER LETTER CAPITALIZED
    public static String returnEOLCased(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 != 0) {
                sb.append(String.valueOf(text.charAt(i)).toUpperCase());
            } else { sb.append(String.valueOf(text.charAt(i)).toLowerCase()); }
        } return sb.toString();
    }
    
    // RETURNS STRING WITH MID-LETTER CAPITALIZED
    public static String returnMidCased(String text) {
        int midPoint = text.length()/2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i == midPoint) {
                sb.append(String.valueOf(text.charAt(i)).toUpperCase());
            } else { sb.append(String.valueOf(text.charAt(i)).toLowerCase()); }
        } return sb.toString();
    }
    
    // RETURNS COMPLETE STRING WITH ALL FIRST LETTERS CAPITALIZED
    public static String toTitleCase(String text) {
        String regex = "\\p{Alpha}+([\\W\\s\\t]|\\b)+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(text);
        StringBuilder casing = new StringBuilder();
        while (mat.find()) {
            casing.append(mat.group().substring(0,1).toUpperCase())
                    .append(mat.group().substring(1).toLowerCase());
        } return casing.toString();
    }
    
    // RETURNS THE FIRST LETTERS OR PHONEMES OF TWO WORDS TRANSPOSED
    public static String returnSpoonerized(String text) {
        String[] array = text.toLowerCase().split("\\s");
        String regex = "^[^aeiou]+";
        Pattern pat = Pattern.compile(regex);
        Matcher mat1 = pat.matcher(array[0]);
        Matcher mat2 = pat.matcher(array[1]);
        String one = mat1.find() ? mat1.group() : mat2.group();
        String two = mat2.find() ? mat2.group() : mat1.group();
        return Cased.toTitleCase(array[0].replace(one, two) +
                " " + array[1].replace(two, one));
    }
}
