/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.controller;

import com.umar.tda.entity.TaskPriority;
import com.umar.tda.entity.TaskStatus;
import com.umar.tda.requestdto.TaskDtoRequest;

import com.umar.tda.responsedto.TaskDtoResponse;
import com.umar.tda.service.TaskService;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author UMAR
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // create task
    @PostMapping("/create")
    public ResponseEntity<TaskDtoResponse> createTask(@RequestBody TaskDtoRequest request) {

        TaskDtoResponse response = taskService.createTask(request);

        return ResponseEntity.ok(response);
    }

    // get list of task
    @GetMapping
    public ResponseEntity<List<TaskDtoResponse>> listTasks() {
        return ResponseEntity.ok(taskService.listAllTask());
    }
    
    @GetMapping("/priority")
    public ResponseEntity<List<TaskDtoResponse>> listPriorityTasks(@RequestParam TaskPriority priority) {
        return ResponseEntity.ok(taskService.listTasksByPriority(priority));
    }
    
    @GetMapping("/status")
    public ResponseEntity<List<TaskDtoResponse>> listStatusTasks(@RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService.listTasksByStatus(status));
    }

    

}
