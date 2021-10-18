package br.com.santarosadigital.todolist.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
class TaskControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void findAll() {
        try {
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/todo");
            MvcResult result = mvc.perform(requestBuilder).andReturn();
            assertEquals(0, result.getResponse().getContentLength());

        } catch (Exception ignored) {

        }
    }
}