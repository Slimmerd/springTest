package ru.test.springTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.springTest.entity.TodoEntity;
import ru.test.springTest.entity.UserEntity;
import ru.test.springTest.exceptions.TodoDontExistException;
import ru.test.springTest.model.Todo;
import ru.test.springTest.repository.TodoRepo;
import ru.test.springTest.repository.UserRepo;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userID){
        UserEntity user = userRepo.findById(userID).get();
        todo.setUser(user);

        return Todo.toModel(todoRepo.save(todo));

    }

    public Todo completedTodo(Long todoID) throws TodoDontExistException {
        TodoEntity todo = todoRepo.findById(todoID).get();

        if (todo == null){
            throw new TodoDontExistException("Todo do not exist");
        }

        todo.setCompleted(!todo.getCompleted());

        return Todo.toModel(todoRepo.save(todo));
    }
}
