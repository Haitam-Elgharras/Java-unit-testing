import com.in28minutes.JUnit.StringHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperParameterizedTest {
    private static StringHelper helper;

    @BeforeAll
    public static void start() {
        helper = new StringHelper();
    }

    @ParameterizedTest
    @CsvSource({
            "AACD, CD",
            "AA, ''",
            "ACD, CD",
            "CADEF, CDEF",
            "CDEF, CDEF",
            "'', ''"
    })
    public void testTruncateAInFirst2Positions(String input, String expected) {
        assertEquals(expected, helper.truncateAInFirst2Positions(input));
    }

    @ParameterizedTest
    @CsvSource({
            "ABCD, false",
            "ABAB, true",
            "A, false",
            "AB, true"
    })
    public void testAreFirstAndLastTwoCharactersTheSame(String input, boolean expected) {
        assertEquals(expected, helper.areFirstAndLastTwoCharactersTheSame(input));
    }
}