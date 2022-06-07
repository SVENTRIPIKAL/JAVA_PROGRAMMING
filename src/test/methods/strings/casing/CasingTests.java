package methods.strings.casing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasingTests {
    
    @Test public void returnsEOLCased_Cat() {
        String text = Cased.returnEOLCased("cat");
        assertEquals("cAt", text);
    }
    
    @Test public void returnsEOLCased_Apple() {
        String text = Cased.returnEOLCased("apple");
        assertEquals("aPpLe", text);
    }
}
