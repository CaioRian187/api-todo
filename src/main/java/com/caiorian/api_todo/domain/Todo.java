package com.caiorian.api_todo.domain;

import java.util.UUID;

public class Todo {

    private Integer id;
    private String descricao;
    private Boolean feita;

    public Todo() {
    }

    public Todo(Integer id, String descricao, Boolean feita) {
        this.id = id;
        this.descricao = descricao;
        this.feita = feita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getFeita() {
        return feita;
    }

    public void setFeita(Boolean feita) {
        this.feita = feita;
    }
}
