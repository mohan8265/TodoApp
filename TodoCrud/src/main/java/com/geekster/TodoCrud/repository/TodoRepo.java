package com.geekster.TodoCrud.repository;

import com.geekster.TodoCrud.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepo {

    private List<Todo> todoList;
    public TodoRepo(){
        todoList = new ArrayList<>();
        todoList.add(new Todo(0,"for checking",true));
    }

    public List<Todo> getAllTodosFromDao(){
        return todoList;
    }
    public boolean save(Todo todo)
    {
        todoList.add(todo);
        return true;
    }
    public boolean remove(Todo todo)
    {
        todoList.remove(todo);
        return true;
    }
    public boolean update(Integer id, boolean status)
    {
        boolean updateStatus = false;
        for(Todo todo : todoList)
        {
            if(todo.getId() == id){
                remove(todo);

                todo.setStatus(status);
                save(todo);
                return true;
            }

        }
        return false;
    }


}
