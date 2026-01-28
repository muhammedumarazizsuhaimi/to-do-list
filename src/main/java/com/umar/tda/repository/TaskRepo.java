/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umar.tda.repository;

import com.umar.tda.entity.Task;
import com.umar.tda.entity.TaskPriority;
import com.umar.tda.entity.TaskStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author UMAR
 */
@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    
    List<Task> findAllByPriority(TaskPriority priority);
    
    List<Task> findAllByStatus(TaskStatus status);
    
    @Query("SELECT t FROM task WHERE t.notification = true AND t.status <>DONE ")
    List<Task>findNofitiableTasks();
    
}
