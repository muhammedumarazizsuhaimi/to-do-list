/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.responsedto;

import java.time.LocalDateTime;
import lombok.Builder;

/**
 *
 * @author UMAR
 */
@Builder
public class TaskDtoResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final String status;
    private final String priority;
    private final LocalDateTime dueDate;
    private final boolean notification;
    private final LocalDateTime completedAt;

    public TaskDtoResponse(Long id, String title, String description, String status, String priority, LocalDateTime dueDate, boolean notification, LocalDateTime completedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.notification = notification;
        this.completedAt = completedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public boolean isNotification() {
        return notification;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

}
