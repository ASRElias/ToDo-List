package br.com.santarosadigital.todolist.dao;

import br.com.santarosadigital.todolist.controller.TaskController;
import br.com.santarosadigital.todolist.enumeration.TaskStatusEnum;
import br.com.santarosadigital.todolist.model.Task;
import br.com.santarosadigital.todolist.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TaskDAO {

    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(Sort sort) {
        logger.info("Searching tasks!");
        return taskRepository.findAll(sort);
    }

    public Optional<Task> findById(Long id){
        logger.info("Searching task with id: {}!", id);
        return taskRepository.findById(id);
    }

    public List<Task> findAllByStatus(TaskStatusEnum status) {
        logger.info("Searching tasks with status: {}!", status.getValue());
        return taskRepository.findAllByStatus(status);
    }

    public Task save(Task task) {
        logger.info("Saving task!");
        task.setInsertDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        logger.info("Updating task!");
        Optional<Task> taskToUpdate = taskRepository.findById(task.getId());
        taskToUpdate.ifPresent(value -> task.setInsertDate(value.getInsertDate()));
        task.setModifyDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        logger.info("Deleting task!");
        taskRepository.deleteById(id);
    }

}
