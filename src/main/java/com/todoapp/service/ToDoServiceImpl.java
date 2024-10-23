package com.todoapp.service;

import com.todoapp.domain.ToDo;
import com.todoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ToDoServiceImpl implements ToDoService{

    private final ToDoRepository toDoRepository;

    public List<ToDo> List(){
        List<ToDo> todoList = toDoRepository.findAll();
        return todoList;
    }

    public String addTodo(String todo){
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return todo;
    }

}
