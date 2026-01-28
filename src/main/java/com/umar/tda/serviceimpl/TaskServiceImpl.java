/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.serviceimpl;

import com.umar.tda.entity.Task;
import com.umar.tda.entity.TaskPriority;
import com.umar.tda.entity.TaskStatus;
import com.umar.tda.repository.TaskRepo;
import com.umar.tda.requestdto.TaskDtoRequest;

import com.umar.tda.responsedto.TaskDtoResponse;
import com.umar.tda.service.TaskService;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author UMAR
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    // 1️⃣ Create Task
    @Override
    public TaskDtoResponse createTask(TaskDtoRequest dto) {
        Task task = new Task();
        task.setTitle(
                dto.getTitle()
        );
        task.setDescription(
                dto.getDescription()
        );
        task.setPriority(
                dto.getPriority() != null
                ? TaskPriority.valueOf(dto.getPriority())
                : TaskPriority.MEDIUM
        );
        task.setStatus(
                dto.getStatus() != null
                ? TaskStatus.valueOf(dto.getStatus())
                : TaskStatus.TODO
        );
        task.setDueDate(
                dto.getDueDate()
        );
        task.setNotification(
                dto.isNotification()
        );
        taskRepo.save(task);

        return TaskDtoResponse
                .builder()
                .id(task.getTaskid())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus().name())
                .priority(task.getPriority().name())
                .dueDate(task.getDueDate())
                .notification(task.isNotification())
                .completedAt(task.getCompletedAt())
                .build();
    }

    // 2️⃣ List Tasks
    @Override
    public List<TaskDtoResponse> listTasks() {

        return taskRepo
                .findAll()
                .stream()
                .map(
                        task -> {
                            return TaskDtoResponse
                                    .builder()
                                    .id(task.getTaskid())
                                    .title(task.getTitle())
                                    .description(task.getDescription())
                                    .status(task.getStatus().name())
                                    .priority(task.getPriority().name())
                                    .dueDate(task.getDueDate())
                                    .completedAt(task.getCompletedAt())
                                    .build();
                        }
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public List<TaskDtoResponse> listTasksByPriority(TaskPriority priority) {

        return taskRepo
                .findAllByPriority(priority)
                .stream()
                .map(
                        task -> {
                            return TaskDtoResponse
                                    .builder()
                                    .id(task.getTaskid())
                                    .title(task.getTitle())
                                    .description(task.getDescription())
                                    .status(task.getStatus().name())
                                    .priority(task.getPriority().name())
                                    .dueDate(task.getDueDate())
                                    .completedAt(task.getCompletedAt())
                                    .build();
                        }
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public List<TaskDtoResponse> listTasksByStatus(TaskStatus status) {

        return taskRepo
                .findAllByStatus(status)
                .stream()
                .map(
                        task -> {
                            return TaskDtoResponse
                                    .builder()
                                    .id(task.getTaskid())
                                    .title(task.getTitle())
                                    .description(task.getDescription())
                                    .status(task.getStatus().name())
                                    .priority(task.getPriority().name())
                                    .dueDate(task.getDueDate())
                                    .completedAt(task.getCompletedAt())
                                    .build();
                        }
                )
                .collect(
                        Collectors.toList()
                );
    }

}
