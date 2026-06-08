package com.caiorian.api_todo.adapter.repository;

import com.caiorian.api_todo.adapter.entities.TodoEntity;
import com.caiorian.api_todo.domain.Todo;
import com.caiorian.api_todo.domain.ports.TodoRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TodoJpaRepositoryAdapter implements TodoRepositoryPort {

    private final TodoJpaRepository todoJpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Todo save(Todo todo) {
        TodoEntity entity = modelMapper.map(todo, TodoEntity.class);
        TodoEntity entitySave = this.todoJpaRepository.save(entity);
        return modelMapper.map(entitySave, Todo.class);
    }

    @Override
    public List<Todo> findAll() {
        List<TodoEntity> listEntity = this.todoJpaRepository.findAll();
        return listEntity.stream().map(
                entity -> modelMapper.map(entity, Todo.class)).collect(Collectors.toList());
    }

    @Override
    public Todo findById(Integer id) {
        TodoEntity entity = this.todoJpaRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Todo de id: " + id + " não encontrado."
                ));
        return modelMapper.map(entity, Todo.class);
    }

    @Override
    public Todo concluirTodo(Integer id) {
        Todo todo = this.findById(id);
        if (!todo.getFeita()){
            todo.setFeita(true);
            this.todoJpaRepository.save(modelMapper.map(todo, TodoEntity.class));
        }
        return todo;
    }
}
