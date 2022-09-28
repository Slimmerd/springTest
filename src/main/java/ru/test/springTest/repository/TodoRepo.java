package ru.test.springTest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.test.springTest.entity.TodoEntity;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {

}
