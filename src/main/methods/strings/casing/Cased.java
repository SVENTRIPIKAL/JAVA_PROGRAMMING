package methods.strings.casing;

public class Cased {
    private Cased() {   }
    
    // RETURNS STRING WITH EVERY OTHER LETTER UPPER-CASED
    public static String returnEOLCased(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 != 0) {
                sb.append(String.valueOf(text.charAt(i)).toUpperCase());
            } else { sb.append(text.charAt(i)); }
        } return sb.toString();
    }
}
