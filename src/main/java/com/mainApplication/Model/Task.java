package com.mainApplication.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * Represents a Task entity in the Task Management System.
 * Each task has properties like title, description, due date, and status.
 */
@Entity
@Data
public class Task {

    /**
     * Unique identifier for each task.
     * Auto-generated using identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title of the task. Cannot be blank and has a maximum length of 255 characters.
     */
    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;

    /**
     * Optional description of the task. Limited to 1000 characters.
     */
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    /**
     * Due date of the task. Must be in the future.
     * Stored in the format 'yyyy-MM-dd'.
     */
    @Future(message = "Due date must be a future date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateTime;

    /**
     * Current status of the task.
     * Enumerated values: PENDING, IN_PROGRESS, COMPLETED.
     */
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * Timestamp of when the task was created.
     * Auto-populated before persisting.
     */
    private LocalDateTime createdAt;

    /**
     * Timestamp of when the task was last updated.
     * Auto-populated before updating.
     */
    private LocalDateTime updatedAt;

    /**
     * Automatically sets the creation and update timestamps.
     */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    /**
     * Automatically updates the update timestamp before saving.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    /**
     * Enumeration representing the status of a task.
     */
    public enum Status {
        PENDING, IN_PROGRESS, COMPLETED
    }

}
