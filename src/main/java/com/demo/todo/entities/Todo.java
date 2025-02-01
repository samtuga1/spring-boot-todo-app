package com.demo.todo.entities;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

import com.demo.todo.validators.CustomBooleanDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "todos")
public class Todo {

    @Id
    @SequenceGenerator(name = "todo_seq", sequenceName = "todo_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq")
    private Long id;

    @NotNull(message = "Text is required")
    @NotBlank(message = "Text cannot be blank")
    @Column(nullable = false)
    private String text;

    @JsonDeserialize(using = CustomBooleanDeserializer.class)
    private boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    public Todo(String text) {
        this.text = text;
        this.completed = false;
    }

}
