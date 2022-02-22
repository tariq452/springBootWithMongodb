package com.abolkog.sprintboot.todos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {

    @GetMapping("")
    public Todo listTodo(){
Todo test = new Todo(1,"first todo","this is my first task");
return test;
    }
}
