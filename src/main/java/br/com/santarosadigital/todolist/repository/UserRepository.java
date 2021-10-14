package br.com.santarosadigital.todolist.repository;

import br.com.santarosadigital.todolist.enumeration.TaskStatusEnum;
import br.com.santarosadigital.todolist.model.Task;
import br.com.santarosadigital.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUserName(String username);
}
