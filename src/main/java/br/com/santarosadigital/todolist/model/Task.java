package br.com.santarosadigital.todolist.model;

import br.com.santarosadigital.todolist.enumeration.TaskStatusEnum;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 2405323990169671794L;

    private Long id;
    @NotNull
    private String userId;
    @NotNull
    private LocalDateTime insertDate;
    private LocalDateTime modifyDate;
    @NotNull
    private String taskAbstract;
    private String taskDescription;
    private TaskStatusEnum status;

    public Task() {
    }

    public Task(Long id, String userId, LocalDateTime insertDate, LocalDateTime modifyDate, String taskAbstract, String taskADescription, TaskStatusEnum status) {
        this.id = id;
        this.userId = userId;
        this.insertDate = insertDate;
        this.modifyDate = modifyDate;
        this.taskAbstract = taskAbstract;
        this.taskDescription = taskADescription;
        this.status = status;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getTaskAbstract() {
        return taskAbstract;
    }

    public void setTaskAbstract(String taskAbstract) {
        this.taskAbstract = taskAbstract;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }
}
