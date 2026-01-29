/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.responsedto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author UMAR
 */
@Data
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

}
