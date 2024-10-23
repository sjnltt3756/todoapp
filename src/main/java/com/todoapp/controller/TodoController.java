package com.todoapp.controller;

import com.todoapp.domain.ToDo;
import com.todoapp.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final ToDoService toDoService;

    @GetMapping("/")
    public String getAllTodosGroupedByDate(Model model){
        Map<LocalDate, List<ToDo>> todosByDate = toDoService.getTodosGroupedByDate();
        model.addAttribute("todosByDate", todosByDate);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo, @RequestParam(required = false) String date){
        LocalDate todoDate = (date != null && !date.isEmpty()) ? LocalDate.parse(date) : LocalDate.now();
        toDoService.addTodo(todo, todoDate);
        return "redirect:/";
    }

    @PostMapping("/updateTodo")
    public String updateTodo(@RequestParam Long id, @RequestParam(required = false) boolean complete) {
        toDoService.complete(id, complete);
        return "redirect:/"; // 업데이트 후 홈으로 리다이렉트
    }
}
