/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.*;

/**
 *
 * @author UMAR
 */
@NoArgsConstructor // required by JPA
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long taskid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private TaskPriority priority = TaskPriority.MEDIUM;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status = TaskStatus.TODO;

    @Column(name = "due")
    private LocalDateTime dueDate;

    @Column(name = "notification", nullable = false)
    private boolean notification = false;

    @Column(name = "created")
    private LocalDateTime createdAt;

    @Column(name = "updated")
    private LocalDateTime updatedAt;

    @Column(name = "completed")
    private LocalDateTime completedAt;
    
    @Column(name= "notified")
    private LocalDateTime lastNotifiedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @Column(name = "category_id")
    private Category category;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}

    // Getters & Setters
