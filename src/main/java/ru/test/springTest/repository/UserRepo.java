package ru.test.springTest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.test.springTest.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
