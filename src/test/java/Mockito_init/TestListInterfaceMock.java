package Mockito_init;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
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

    // testing calling unstubbed methods
    @Test
    public void testListGet_unstubbedMethods() {
        List listMock = mock(List.class);

        assertNull(listMock.get(0));
        assertEquals(0, listMock.size());

        assertFalse(listMock.isEmpty());

        assertFalse(listMock.contains("in28Minutes"));

        assertEquals(0, listMock.indexOf("in28Minutes"));
    }

    // Playground for BDD Mockito
    @Test
    public void testListGet_BDD() {
        // Given
        List listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("in28Minutes");

        // When
        String firstElement = (String) listMock.get(0);

        // Then
        assertThat(firstElement, is("in28Minutes"));
    }

    @Test
    public void testListGet_throwException_BDD() {
        // Given
        List listMock = mock(List.class);

        given(listMock.get(anyInt())).willReturn(new RuntimeException("Something"));

        // When
        Runnable listMockCall = () -> listMock.get(0);

        // Then
        assertThrows(RuntimeException.class, listMockCall::run);
    }
}
