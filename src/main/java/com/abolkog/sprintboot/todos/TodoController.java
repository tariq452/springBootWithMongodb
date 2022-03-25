package com.abolkog.sprintboot.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Todo>> getAllTodo(){
     List<Todo> result=todoService.findAll();
     return new ResponseEntity<>(result,HttpStatus.MULTI_STATUS.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String id){
         Todo result=todoService.getById(id);
         return new ResponseEntity<>(result,HttpStatus.MULTI_STATUS.OK);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Todo> createNewTodo(@Valid @RequestBody  Todo todo){
        Todo result=todoService.save(todo);
       return new ResponseEntity<>(result, HttpStatus.MULTI_STATUS.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.MULTI_STATUS.NO_CONTENT);
    }

}
