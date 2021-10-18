package br.com.santarosadigital.todolist.controller;

import br.com.santarosadigital.todolist.model.Task;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskControllerTest {

    @Test
    public void shouldGetTaskList() {
        TaskController taskController = new TaskController();
        List<Task> tasks = taskController.findAll("XPTO");
        List<Task> expectedResponse = Collections.emptyList();
        assertNotNull(tasks);
        assertNotEquals(tasks, expectedResponse, "It should be empty");
    }

}