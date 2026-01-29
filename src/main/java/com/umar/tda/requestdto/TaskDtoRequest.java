/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.requestdto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author UMAR
 */
@Data
@NoArgsConstructor
public class TaskDtoRequest {

    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime dueDate;
    private boolean notification;

}
