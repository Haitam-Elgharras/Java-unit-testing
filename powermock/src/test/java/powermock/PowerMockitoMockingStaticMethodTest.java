package powermock;

import com.in28minutes.junit.powermock.Dependency;
import com.in28minutes.junit.powermock.SystemUnderTest;
import com.in28minutes.junit.powermock.UtilityClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UtilityClass.class})
public class PowerMockitoMockingStaticMethodTest {

    @Mock
    private Dependency dependencyMock;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void shouldMockStaticMethodCall() {

        // Arrange
        mockDependency();
        mockStaticMethod();

        // Act
        int result = systemUnderTest.methodCallingAStaticMethod();

        // Assert
        assertEquals(150, result);
        verifyStaticMethodCall();
    }

    private void mockDependency() {
        when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));
    }

    private void mockStaticMethod() {
        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.staticMethod(anyLong())).thenReturn(150);
    }

    private void verifyStaticMethodCall() {
        PowerMockito.verifyStatic(UtilityClass.class);
        UtilityClass.staticMethod(1 + 2 + 3);
        PowerMockito.verifyStatic(UtilityClass.class, Mockito.times(1));
    }
}