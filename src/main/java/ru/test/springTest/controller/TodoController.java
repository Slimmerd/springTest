package ru.test.springTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.springTest.entity.TodoEntity;
import ru.test.springTest.exceptions.TodoDontExistException;
import ru.test.springTest.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userID){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userID));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long todoID){
        try {
            return ResponseEntity.ok(todoService.completedTodo(todoID));
        } catch (TodoDontExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
