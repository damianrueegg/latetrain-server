package ch.ffhs.pa5.latetrain.latetrainserver.controller;

import ch.ffhs.pa5.latetrain.latetrainserver.exception.UserNotFoundException;
import ch.ffhs.pa5.latetrain.latetrainserver.model.User;
import ch.ffhs.pa5.latetrain.latetrainserver.model.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    //Aggregate root

    @GetMapping("/users")
    List<User> all(){
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    //Single item

    @GetMapping("/users({id}")
    User one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
