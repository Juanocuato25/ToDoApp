package com.toDoApi.todoApiRest.service;

import com.toDoApi.todoApiRest.exceptions.ToDoExceptions;
import com.toDoApi.todoApiRest.mapper.TaskInDTOToTask;
import com.toDoApi.todoApiRest.persistence.entity.Task;
import com.toDoApi.todoApiRest.persistence.entity.TaskStatus;
import com.toDoApi.todoApiRest.persistence.repository.TaskRepository;
import com.toDoApi.todoApiRest.service.dto.TaskInDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    private final TaskRepository taskRepository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask taskInDTOToTask, TaskInDTOToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.taskRepository.save(task);
    }

    public List<Task> getAllTask() {
        return this.taskRepository.findAll();
    }

    public List<Task> getAllByStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.updateFinishedStatus(id);

    }

    @Transactional
    public void deleteTask(@PathVariable Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }
}
