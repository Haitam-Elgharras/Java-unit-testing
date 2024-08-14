import com.in28minutes.JUnit.StringHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperTest {
    @Test
    public void testTruncateAInFirst2Positions() {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
    }
}
