package com.geekster.TodoCrud.service;

import com.geekster.TodoCrud.model.Todo;
import com.geekster.TodoCrud.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;


    public String addTodo(Todo todo) {
        boolean insertStatus = todoRepo.save(todo);
        if (insertStatus){
            return "Todo added successfully";
        }else {
            return "Failed...";
        }
    }
    public List<Todo> getTodos() {
        return todoRepo.getAllTodosFromDao();
    }

    public Todo getTodo(Integer id) {
        List<Todo> currentTodoList = todoRepo.getAllTodosFromDao();
        Todo todo1 = null;
        for(Todo todo:currentTodoList){
            if(id == todo.getId()){
                todo1 = todo;
                break;
            }
        }
        return todo1;
    }

    public List<Todo> getTodosByStatus(String  status) {
        List<Todo> currentTodoList = todoRepo.getAllTodosFromDao();
        List<Todo> resultlist = new ArrayList<>();

        for(Todo todo:currentTodoList){
            if(Boolean.parseBoolean(status) == todo.isStatus()){
                resultlist.add(todo);
            }
        }
        return resultlist;
    }

    public String deleteTodo(Integer id) {
        List<Todo> currentTodoList = todoRepo.getAllTodosFromDao();
         boolean deleteStatus = false;
        for (Todo todo:currentTodoList){
            if(id == todo.getId()){
                todoRepo.remove(todo);
                deleteStatus = true;
                break;
            }
        }
        if(deleteStatus){
            return "Todo deleted";
        }else {
            return "Todo doesn't exist..";
        }
    }

    public String updateStatus(Integer id, String status) {
        boolean updateStatus = todoRepo.update(id,Boolean.parseBoolean(status));
        if(updateStatus){
            return "Todo updated..";
        }else {
            return "Todo doesn't exist..";
        }
    }
}
