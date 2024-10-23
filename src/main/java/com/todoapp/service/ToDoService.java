package com.todoapp.service;

import com.todoapp.domain.ToDo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ToDoService {
    public Map<LocalDate, List<ToDo>> getTodosGroupedByDate();
    public ToDo addTodo(String todo, LocalDate date);
    public ToDo complete(Long id, boolean complete);
}
