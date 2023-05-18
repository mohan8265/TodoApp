package com.geekster.TodoCrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Integer id;
    private String todoName;
    private boolean status;
}
