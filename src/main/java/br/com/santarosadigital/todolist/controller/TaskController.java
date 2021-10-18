package br.com.santarosadigital.todolist.controller;

import br.com.santarosadigital.todolist.enumeration.TaskStatusEnum;
import br.com.santarosadigital.todolist.model.Task;
import br.com.santarosadigital.todolist.repository.TaskRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/v1/api-todo")
public class TaskController extends Diagnostics {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(path = "/todo", produces = {"application/json"})
    public List<Task> findAll(@RequestHeader(value = "x-token", defaultValue = "") String token) {
        if (token.equals("")) {
            return Collections.emptyList();
        }
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC,"status"));
    }

    @GetMapping(path = "/todo/{id}", produces = {"application/json"})
    public Optional<Task> findById(@RequestHeader(value = "x-token", defaultValue = "") String token, @PathVariable("id") Long taskId) {
        if (token.equals("")) {
            return Optional.empty();
        }
        return taskRepository.findById(taskId);
    }

    @GetMapping(path = "/todo/status/{status}", produces = {"application/json"})
    public List<Task> findByStatus(@RequestHeader(value = "x-token", defaultValue = "") String token, @PathVariable("status")TaskStatusEnum status) {
        if (token.equals("")) {
            return Collections.emptyList();
        }
        return taskRepository.findAllByStatus(status); }

    @PostMapping(path = "/todo")
    public Task save(@RequestHeader(value = "x-token", defaultValue = "") String token, @Validated @NotNull @RequestBody Task task) {
        if (token.equals("")) {
            return null;
        }
        task.setInsertDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @PutMapping(path = "/todo")
    public Task update(@RequestHeader(value = "x-token", defaultValue = "") String token, @Validated @NotNull @RequestBody Task task) {
        if (token.equals("")) {
            return null;
        }
        Optional<Task> taskToUpdate = taskRepository.findById(task.getId());
        taskToUpdate.ifPresent(value -> task.setInsertDate(value.getInsertDate()));
        task.setModifyDate(LocalDateTime.now());
        return taskRepository.save(task); }

    @DeleteMapping(path = "/todo/{id}")
    public void delete(@RequestHeader(value = "x-token", defaultValue = "") String token, @PathVariable Long id) {
        if (token.equals("")) {
            return;
        }
        taskRepository.deleteById(id); }

    @Override
    @GetMapping(path = "/info", produces = { "application/json" })
    public String info() {
        return "{ \"info\": \"API TODO LIST\", \"version\" : \"v1\" }";
    }

}
