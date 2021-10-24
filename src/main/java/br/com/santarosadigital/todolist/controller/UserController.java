package br.com.santarosadigital.todolist.controller;

import br.com.santarosadigital.todolist.dao.UserDAO;
import br.com.santarosadigital.todolist.model.User;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @PostMapping
    public User save(@Validated @NotNull @RequestBody User user) {
        return userDAO.save(user);
    }

}
