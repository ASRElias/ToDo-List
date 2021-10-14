package br.com.santarosadigital.todolist.controller;

import br.com.santarosadigital.todolist.model.Task;
import br.com.santarosadigital.todolist.model.User;
import br.com.santarosadigital.todolist.repository.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public User save(@Validated @NotNull @RequestBody User user) {
        return userRepository.save(user);
    }

}
