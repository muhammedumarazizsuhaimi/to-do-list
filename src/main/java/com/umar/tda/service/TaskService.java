/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umar.tda.service;

import com.umar.tda.entity.TaskPriority;
import com.umar.tda.entity.TaskStatus;
import com.umar.tda.requestdto.TaskDtoRequest;
import com.umar.tda.responsedto.TaskDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author UMAR
 */
@Service
public interface TaskService {
    
    TaskDtoResponse createTask(TaskDtoRequest dto);
    
    List<TaskDtoResponse> listAllTask();
    
    List<TaskDtoResponse> listTasksByPriority(TaskPriority priority);
    
    List<TaskDtoResponse> listTasksByStatus(TaskStatus status);
    
    
    
    
    
}
