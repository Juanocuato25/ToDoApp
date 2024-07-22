package com.toDoApi.todoApiRest.mapper;

import com.toDoApi.todoApiRest.persistence.entity.Task;
import com.toDoApi.todoApiRest.persistence.entity.TaskStatus;
import com.toDoApi.todoApiRest.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component//Con esta anotacion lo podemos inyectar en otras clases
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

    //Mapper pa
    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
