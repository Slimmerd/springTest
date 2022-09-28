package ru.test.springTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.test.springTest.entity.UserEntity;
import ru.test.springTest.exceptions.UserAlreadyExistException;
import ru.test.springTest.exceptions.UserDontExistException;
import ru.test.springTest.model.User;
import ru.test.springTest.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity register(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("User already exist");
        }

        return userRepo.save(user);
    }

    public User getUser(Long Id) throws UserDontExistException {
        UserEntity user = userRepo.findById(Id).get();

        if (user == null){
            throw new UserDontExistException("User do not exist");
        }

        return User.toModel(user);

    }

    public Long deleteUser(Long Id){
        userRepo.deleteById(Id);

        return Id;
    }
}
