package com.todoapp.service;

import com.todoapp.domain.ToDo;

import java.util.List;

public interface ToDoService {
    public List<ToDo> List();
    public String addTodo(String todo);
}
