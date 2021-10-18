package br.com.santarosadigital.todolist.enumeration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskStatusEnumTest {

    @Test
    void getValue() {
        assertEquals("PENDING", TaskStatusEnum.PENDING.getValue());
        assertEquals("COMPLETED", TaskStatusEnum.COMPLETED.getValue());
    }

    @Test
    void getEnum() {
        assertEquals(TaskStatusEnum.PENDING, TaskStatusEnum.getEnum("PENDING"));
        assertEquals(TaskStatusEnum.COMPLETED, TaskStatusEnum.getEnum("COMPLETED"));
    }

}