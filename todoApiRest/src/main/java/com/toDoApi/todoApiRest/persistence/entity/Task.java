package com.toDoApi.todoApiRest.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;
    @Basic
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;//abreviacion de fecha de terminacion estimada
    private boolean finished;
    private TaskStatus taskStatus;


}
