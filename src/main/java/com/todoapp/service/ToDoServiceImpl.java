package com.todoapp.service;

import com.todoapp.domain.ToDo;
import com.todoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class ToDoServiceImpl implements ToDoService{

    private final ToDoRepository toDoRepository;

    public Map<LocalDate, List<ToDo>> getTodosGroupedByDate() {
        List<ToDo> todos = toDoRepository.findAll();
        // 날짜별로 할 일 목록을 그룹화하여 Map으로 반환
        return todos.stream().collect(Collectors.groupingBy(ToDo::getToday));
    }

    public ToDo addTodo(String todo, LocalDate date){
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDo.setComplete(false);
        toDo.setToday(date != null ? date : LocalDate.now());
        return toDoRepository.save(toDo);
    }

    public ToDo complete(Long id, boolean complete){
        ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 할 일 ID: " + id));
        todo.setComplete(complete);
        return toDoRepository.save(todo);
    }


}
