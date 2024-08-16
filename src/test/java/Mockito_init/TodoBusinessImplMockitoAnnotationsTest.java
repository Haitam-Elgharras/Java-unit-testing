package Mockito_init;

import com.in28minutes.Mockito.business.TodoBusinessImpl;
import com.in28minutes.Mockito.data.api.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TodoBusinessImplMockitoAnnotationsTest {

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    void retrieveTodosRelatedToSpring_usingMock() {
        when(todoServiceMock.retrieveTodos("user_learning_spring")).thenReturn(
                Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Spring"));

        assertEquals(3, todoBusinessImpl.retrieveTodosRelatedToSpring("user_learning_spring").size());
    }

    @Test
    void retrieveTodosRelatedToSpring_usingMockWithEmptyList() {
        when(todoServiceMock.retrieveTodos("empty")).thenReturn(List.of());

        assertEquals(0, todoBusinessImpl.retrieveTodosRelatedToSpring("empty").size());
    }

    @Test
    void deleteNotRelatedToSpring_usingMock() {
        when(todoServiceMock.retrieveTodos("user_learning_spring")).thenReturn(
                Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Java"));

        todoBusinessImpl.deleteTodosNotRelatedToSpring("user_learning_spring");

        verify(todoServiceMock, times(1)).deleteTodo("Learn Java");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
    }

    @Test
    void deleteNotRelatedToSpring_usingBDD() {
        // Given
        given(todoServiceMock.retrieveTodos("user_learning_spring")).willReturn(
                Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Java"));

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("user_learning_spring");

        // Then
        // this is similar to verify(todoServiceMock).deleteTodo("Learn Java");
        then(todoServiceMock).should().deleteTodo("Learn Java");
        then(todoServiceMock).should(times(1)).deleteTodo("Learn Java");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
    }

    @Test
    void deleteNotRelatedToSpring_usingBDD_argumentCapture() {
        // Given
        given(todoServiceMock.retrieveTodos("user_learning_spring")).willReturn(
                Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Java"));

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("user_learning_spring");

        // Then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn Java"));
    }

    @Test
    void deleteNotRelatedToSpring_usingBDD_list_argumentCapture() {
        // Given
        given(todoServiceMock.retrieveTodos("user_learning_spring")).willReturn(
                Arrays.asList("Learn Spring MVC", "Learn docker", "Learn Java"));

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("user_learning_spring");

        // Then
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }

}