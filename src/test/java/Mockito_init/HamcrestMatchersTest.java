package Mockito_init;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void test() {
        List<Integer> scores = List.of(99, 100, 101, 105);

        // List
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(99, 100));
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(greaterThanOrEqualTo(99)));
        assertThat(scores, everyItem(lessThan(190)));

        // string
        assertThat("", is(emptyString()));
        assertThat("  ", is(blankOrNullString()));
        assertThat(null, is(nullValue()));

        // Arrays
        Integer[] marks = {1, 2, 3};
        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1, 2, 3));
        assertThat(marks, arrayContainingInAnyOrder(2, 1, 3));
    }
}
