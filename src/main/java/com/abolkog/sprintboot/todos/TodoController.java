package com.abolkog.sprintboot.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"", "/"})
    public List<Todo> getAllTodo(){
    return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id){
        return todoService.getById(id);
    }

    @PostMapping(value = {"", "/"})
    public boolean createNewTodo(@RequestBody  Todo todo){
       return todoService.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        todoService.delete(id);
    }

}
