package com.caiorian.api_todo.domain.services;

import com.caiorian.api_todo.domain.Todo;
import com.caiorian.api_todo.domain.ports.TodoRepositoryPort;
import com.caiorian.api_todo.domain.ports.TodoServicePort;

import java.util.List;

public class TodoService implements TodoServicePort {

    private final TodoRepositoryPort todoRepositoryPort;

    public TodoService(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepositoryPort.save(todo);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepositoryPort.findAll();
    }

    @Override
    public Todo findById(Integer id) {
        return todoRepositoryPort.findById(id);
    }

    @Override
    public Todo concluirTodo(Integer id) {
        return todoRepositoryPort.concluirTodo(id);
    }

}
