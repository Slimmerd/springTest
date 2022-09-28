package ru.test.springTest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.springTest.entity.UserEntity;
import ru.test.springTest.exceptions.UserAlreadyExistException;
import ru.test.springTest.exceptions.UserDontExistException;
import ru.test.springTest.repository.UserRepo;
import ru.test.springTest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserEntity user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("User saved");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @GetMapping("/")
    public ResponseEntity getUser(@RequestParam Long param){
        try {
            return ResponseEntity.ok(userService.getUser(param));
        } catch (UserDontExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        }  catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }


    @GetMapping()
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Bob");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
