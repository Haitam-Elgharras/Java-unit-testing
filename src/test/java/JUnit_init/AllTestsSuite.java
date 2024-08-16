package JUnit_init;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({
        StringHelperTest.class,
        StringHelperParameterizedTest.class,
        ArrayCompareTest.class
})
@SuiteDisplayName("JUnit 5 All Tests Suite")
public class AllTestsSuite {
    // This class remains empty, it is used only as a holder for the above annotations
}