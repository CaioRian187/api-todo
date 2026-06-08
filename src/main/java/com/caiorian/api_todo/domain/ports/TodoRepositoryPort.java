package com.caiorian.api_todo.domain.ports;

import com.caiorian.api_todo.domain.Todo;

import java.util.List;

public interface TodoRepositoryPort {

    Todo save(Todo todo);
    List<Todo> findAll();
    Todo findById(Integer id);
}
