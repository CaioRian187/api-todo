package com.caiorian.api_todo.config;

import com.caiorian.api_todo.domain.ports.TodoRepositoryPort;
import com.caiorian.api_todo.domain.services.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public TodoService todoService(TodoRepositoryPort todoRepositoryPort){
        return new TodoService(todoRepositoryPort);
    }
}
