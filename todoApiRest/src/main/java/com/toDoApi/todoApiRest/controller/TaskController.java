package com.toDoApi.todoApiRest.controller;

import com.toDoApi.todoApiRest.persistence.entity.Task;
import com.toDoApi.todoApiRest.persistence.entity.TaskStatus;
import com.toDoApi.todoApiRest.service.TaskService;
import com.toDoApi.todoApiRest.service.dto.TaskInDTO;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return taskService.createTask(taskInDTO);
    }


    @GetMapping
    public List<Task> getAllTask(){
        return this.taskService.getAllTask();
    }

    @GetMapping("/status/{status}")
    public List<Task> getAllTaskByStatus(@PathVariable TaskStatus status){
        return this.taskService.getAllByStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable Long id){
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        this.taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
