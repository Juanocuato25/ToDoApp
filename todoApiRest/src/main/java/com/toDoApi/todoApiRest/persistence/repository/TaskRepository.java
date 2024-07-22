package com.toDoApi.todoApiRest.persistence.repository;

import com.toDoApi.todoApiRest.persistence.entity.Task;
import com.toDoApi.todoApiRest.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {

    //QueryMethod
    public List<Task> findAllByTaskStatus(TaskStatus status);


    //query nativa
    @Modifying//Query de actualizacion
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE id_task=:id;", nativeQuery = true)
    public void updateFinishedStatus(@Param("id") Long id);
}
