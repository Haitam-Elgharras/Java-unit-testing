package Mockito_init;

import com.in28minutes.Mockito.business.TodoBusinessImpl;
import com.in28minutes.Mockito.data.api.TodoService;
import com.in28minutes.Mockito.data.api.TodoServiceImplStub;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoBusinessImplTest {

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
}