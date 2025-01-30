package com.demo.todo.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String text;

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
