package JUnit_init;

import com.in28minutes.JUnit.StringHelper;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperTest {
    private StringHelper helper;

    @BeforeEach
    public void setUp() {
        System.out.println("Setting it up before each test");
        helper = new StringHelper();
    }

    @AfterEach
    public void destroy() {
        System.out.println("Destroying it after each test");
        helper = null;
    }

    @BeforeAll
    public static void start() {
        System.out.println("Starting tests");
    }

    @AfterAll
    public static void end() {
        System.out.println("Ending tests");
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }
    @Test
    public void testTruncateAInFirst2Positions_PureA() {
        assertEquals("", helper.truncateAInFirst2Positions("AA"));
    }
    @Test
    public void testTruncateAInFirst2Positions_AInFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }
    @Test
    public void testTruncateAInFirst2Positions_AInSecondPosition() {
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CADEF"));
    }
    @Test
    public void testTruncateAInFirst2Positions_NoAInFirst2Positions() {
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
    }
    @Test
    public void testTruncateAInFirst2Positions_EmptyString() {
        assertEquals("", helper.truncateAInFirst2Positions(""));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_SingleCharacter() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
        // assertFalse("test failed", helper.areFirstAndLastTwoCharactersTheSame("A"));
    }
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_TwoCharacters() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
    }
}
