package Mockito_init;

import com.in28minutes.Mockito.business.TodoBusinessImpl;
import com.in28minutes.Mockito.data.api.TodoService;
import com.in28minutes.Mockito.data.api.TodoServiceImplStub;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class TodoBusinessImplTest {

    // argument captor
    ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

    // skip this when revising its using stub
    @Test
    void retrieveTodosRelatedToSpring() {
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(new TodoServiceImplStub());

        assertEquals(2, todoBusinessImpl.retrieveTodosRelatedToSpring("user_learning_spring").size());
    }

    @Test
    void retrieveTodosRelatedToSpring_usingMock() {
        TodoService todoServiceMock = mock(TodoService.class);
        when(todoServiceMock.retrieveTodos("user_learning_spring")).thenReturn(
                Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Spring"));

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        assertEquals(3, todoBusinessImpl.retrieveTodosRelatedToSpring("user_learning_spring").size());
    }

    @Test
    void retrieveTodosRelatedToSpring_usingMockWithEmptyList() {
        TodoService todoServiceMock = mock(TodoService.class);
        when(todoServiceMock.retrieveTodos("empty")).thenReturn(List.of());

        var todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        assertEquals(0, todoBusinessImpl.retrieveTodosRelatedToSpring("empty").size());
    }

    @Test
    void deleteNotRelatedToSpring_usingMock() {
        TodoService todoServiceMock = mock(TodoService.class);
        when(todoServiceMock.retrieveTodos("user_learning_spring")).thenReturn(
                Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Java"));

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("user_learning_spring");

        verify(todoServiceMock, times(1)).deleteTodo("Learn Java");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
    }

    @Test
    void deleteNotRelatedToSpring_usingBDD() {
        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("user_learning_spring")).willReturn(
                Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Java"));

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

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
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("user_learning_spring")).willReturn(
                Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Java"));

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("user_learning_spring");

        // Then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn Java"));
    }

    @Test
    void deleteNotRelatedToSpring_usingBDD_list_argumentCapture() {
        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("user_learning_spring")).willReturn(
                Arrays.asList("Learn Spring MVC", "Learn docker", "Learn Java"));

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("user_learning_spring");

        // Then
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }

    @Test
    void try_spy() {
        // with spy we are really working with a real implementation
        List list = spy(ArrayList.class);
        list.add("in28Minutes");
        list.add("in28Minutes");

        assertEquals(2, list.size());

        // if we mock a method then it will start behaving like a mock
        when(list.size()).thenReturn(5);

        assertEquals(5, list.size());

    }


}