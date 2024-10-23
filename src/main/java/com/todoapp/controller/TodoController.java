package com.todoapp.controller;

import com.todoapp.domain.ToDo;
import com.todoapp.repository.ToDoRepository;
import com.todoapp.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final ToDoRepository toDoRepository;
    private final ToDoService toDoService;

    @GetMapping("/")
    public String index(Model model){
        List<ToDo> todos = toDoService.List();
        model.addAttribute("todos",todos);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        toDoService.addTodo(todo);
        return "redirect:/";
    }

}
