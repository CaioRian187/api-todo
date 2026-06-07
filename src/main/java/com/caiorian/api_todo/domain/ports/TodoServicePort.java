package com.caiorian.api_todo.domain.ports;

import com.caiorian.api_todo.domain.Todo;

import java.util.List;

public interface TodoServicePort {

    Todo saveTodo(Todo todo);
    List<Todo> findAll();

}
