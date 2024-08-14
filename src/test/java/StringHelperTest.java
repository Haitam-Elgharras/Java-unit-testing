import com.in28minutes.JUnit.StringHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperTest {
    @Test
    public void testTruncateAInFirst2Positions_When_AInFirst2Positions() {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }
    @Test
    public void testTruncateAInFirst2Positions_When_PureA() {
        StringHelper helper = new StringHelper();
        assertEquals("", helper.truncateAInFirst2Positions("AA"));
    }
    @Test
    public void testTruncateAInFirst2Positions_When_AInFirstPosition() {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }
    @Test
    public void testTruncateAInFirst2Positions_When_AInSecondPosition() {
        StringHelper helper = new StringHelper();
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CADEF"));
    }
    @Test
    public void testTruncateAInFirst2Positions_When_NoAInFirst2Positions() {
        StringHelper helper = new StringHelper();
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
    }
    @Test
    public void testTruncateAInFirst2Positions_When_EmptyString() {
        StringHelper helper = new StringHelper();
        assertEquals("", helper.truncateAInFirst2Positions(""));
    }
}
