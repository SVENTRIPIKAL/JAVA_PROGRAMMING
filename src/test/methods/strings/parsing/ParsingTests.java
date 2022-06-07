package methods.strings.parsing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingTests {
    @Test public void createObjectFromInfo() {
        String billy = "Billy, Bob, 1234 Big St., Big City, California, 90210";
        Object parsed = Parsed.returnObjectFromInfo(billy);
    
        assert parsed != null;
        assertEquals(billy, parsed.toString());
    }
}
