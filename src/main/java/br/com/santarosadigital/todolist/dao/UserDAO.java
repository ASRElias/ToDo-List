package br.com.santarosadigital.todolist.dao;

import br.com.santarosadigital.todolist.model.User;
import br.com.santarosadigital.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

}
