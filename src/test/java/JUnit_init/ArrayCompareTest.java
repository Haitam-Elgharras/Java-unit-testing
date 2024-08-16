package JUnit_init;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayCompareTest {

    @Test
    public void testArraySort_RandomArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};
         Arrays.sort(numbers);
         assertArrayEquals(expected, numbers);
    }

    // if the exception is not thrown, the test will fail
    @Test
    public void testArraySort_NullArray() {
        int[] numbers = null;
        assertThrows(NullPointerException.class, () ->Arrays.sort(numbers));
    }
}
