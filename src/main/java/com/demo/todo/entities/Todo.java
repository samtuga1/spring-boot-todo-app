package com.demo.todo.entities;

import jakarta.persistence.Id;

import com.demo.todo.validators.CustomBooleanDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "todos")
public class Todo {

    private @Id @GeneratedValue Long id;

    @NotNull(message = "Text is required")
    @NotBlank(message = "Text cannot be blank")
    @Column(nullable = false)
    private String text;

    @JsonDeserialize(using = CustomBooleanDeserializer.class)
    private boolean completed;

    // needed by JPA
    protected Todo() {
    };

    public Todo(String text) {
        this.text = text;
        this.completed = false;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", text='" + getText() + "'" +
                ", completed='" + getCompleted() + "'" +
                "}";
    }

}
