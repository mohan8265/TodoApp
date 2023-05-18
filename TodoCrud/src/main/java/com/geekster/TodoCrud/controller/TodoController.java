package com.geekster.TodoCrud.controller;

import com.geekster.TodoCrud.model.Todo;
import com.geekster.TodoCrud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping()
    public String addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }
    @GetMapping()
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }
    @GetMapping("/getTodoById/{id}")
    public Todo getTodo(@PathVariable Integer id){
        return todoService.getTodo(id);
    }
    @GetMapping("/getTodoByStatus/{status}")
    public List<Todo> getTodosByStatus(@PathVariable String  status){
        return todoService.getTodosByStatus(status);
    }
    @DeleteMapping("/deleteTodoById/{id}")
    public String deleteTodo(@PathVariable Integer id){
        return todoService.deleteTodo(id);
    }
    @PutMapping("/updateStatusById/{id}/{status}")
    public String updateStatus(@PathVariable Integer id,@PathVariable String status){
        return todoService.updateStatus(id,status);
    }

}
