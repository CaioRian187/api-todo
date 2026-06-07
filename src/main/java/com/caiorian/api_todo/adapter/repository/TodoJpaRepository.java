package com.caiorian.api_todo.adapter.repository;

import com.caiorian.api_todo.adapter.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<TodoEntity, Integer> {
}
