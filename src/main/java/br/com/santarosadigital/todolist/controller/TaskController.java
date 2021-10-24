package br.com.santarosadigital.todolist.controller;

import br.com.santarosadigital.todolist.dao.TaskDAO;
import br.com.santarosadigital.todolist.enumeration.TaskStatusEnum;
import br.com.santarosadigital.todolist.model.Task;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/api-todo")
public class TaskController extends Diagnostics {

    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskDAO taskDAO;

    @GetMapping(path = "/todo", produces = {"application/json"})
    public List<Task> findAll(@RequestHeader(value = "xToken", defaultValue = "") String token) {
        if (token.equals("")) {
            logger.info("Token is empty");
            return Collections.emptyList();
        }
        return taskDAO.findAll(Sort.by(Sort.Direction.ASC,"status"));
    }

    @GetMapping(path = "/todo/{taskId}", produces = {"application/json"})
    public Optional<Task> findById(@RequestHeader(value = "xToken", defaultValue = "") String token, @PathVariable("taskId") Long taskId) {
        if (token.equals("")) {
            logger.info("Token is empty");
            return Optional.empty();
        }
        return taskDAO.findById(taskId);
    }

    @GetMapping(path = "/todo/status/{status}", produces = {"application/json"})
    public List<Task> findAllByStatus(@RequestHeader(value = "xToken", defaultValue = "") String token, @PathVariable("status")TaskStatusEnum status) {
        if (token.equals("")) {
            logger.info("Token is empty");
            return Collections.emptyList();
        }
        return taskDAO.findAllByStatus(status); }

    @PostMapping(path = "/todo")
    public Task save(@RequestHeader(value = "xToken", defaultValue = "") String token, @Validated @NotNull @RequestBody Task task) {
        if (token.equals("")) {
            return null;
        }
        return taskDAO.save(task);
    }

    @PutMapping(path = "/todo")
    public Task update(@RequestHeader(value = "xToken", defaultValue = "") String token, @Validated @NotNull @RequestBody Task task) {
        if (token.equals("")) {
            logger.info("Token is empty");
            return null;
        }
        return taskDAO.update(task); }

    @DeleteMapping(path = "/todo/{taskId}")
    public void delete(@RequestHeader(value = "xToken", defaultValue = "") String token, @PathVariable("taskId") Long taskId) {
        if (token.equals("")) {
            logger.info("Token is empty");
            return;
        }
        taskDAO.delete(taskId);
        }

    @Override
    @GetMapping(path = "/info", produces = { "application/json" })
    public String info() {
        return "{ \"info\": \"API TODO LIST\", \"version\" : \"v1\" }";
    }

}
