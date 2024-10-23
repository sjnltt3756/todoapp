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
        return toDoRepository.findAll();
    }

    public ToDo addTodo(String todo){
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDo.setComplete(false);
        return toDoRepository.save(toDo);
    }

    public ToDo complete(Long id, boolean complete){
        ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 할 일 ID: " + id));
        todo.setComplete(complete);
        return toDoRepository.save(todo);
    }


}
