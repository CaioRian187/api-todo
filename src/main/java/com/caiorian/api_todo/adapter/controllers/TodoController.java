package com.caiorian.api_todo.adapter.controllers;

import com.caiorian.api_todo.domain.Todo;
import com.caiorian.api_todo.domain.ports.TodoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoServicePort todoServicePort;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.todoServicePort.saveTodo(todo));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.todoServicePort.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.todoServicePort.findById(id));
    }

    @PutMapping("/concluir/{id}")
    public ResponseEntity<Todo> concluirTodo(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.todoServicePort.concluirTodo(id));
    }

}
