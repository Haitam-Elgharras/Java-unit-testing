package Mockito_init;

import com.in28minutes.Mockito.business.TodoBusinessImpl;
import com.in28minutes.Mockito.data.api.TodoServiceImplStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoBusinessImplTest {

    @Test
    void retrieveTodosRelatedToSpring() {
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(new TodoServiceImplStub());

        assertEquals(2, todoBusinessImpl.retrieveTodosRelatedToSpring("user_learning_spring").size());
    }
}