package Mockito_init;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// This code is like a simulation that we have a class that depends on a List interface so we can mock it this way
public class TestListInterfaceMock {

    @Test
    public void testListSize() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        assertEquals(2, listMock.size());
    }

    @Test
    public void testListSize_multipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void testListGet() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("in28Minutes");

        assertEquals("in28Minutes", listMock.get(0));

        // This is called nice mock which means that Mockito will return a default value for the method that is not stubbed.
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void testListGet_GenericParameter() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("in28Minutes");

        assertEquals("in28Minutes", listMock.get(50));
    }

    @Test
    public void testListGet_throwException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        assertThrows(RuntimeException.class, () -> listMock.get(0));
    }
}
