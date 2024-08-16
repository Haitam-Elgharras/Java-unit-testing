package com.in28minutes.Mockito.data.api;

import java.util.List;

public class TodoServiceImplStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return List.of(
                "Learn Spring MVC",
                "Learn Spring",
                "Learn to Dance"
        );
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
