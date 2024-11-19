package com.mainApplication.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mainApplication.Model.Task;
import com.mainApplication.Service.TaskManagerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskManagerController {

	@Autowired
	public TaskManagerService taskService;
	 /**
     * Retrieves all tasks.
     *
     * @return List of all tasks.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Retrieves a specific task by ID.
     *
     * @param id ID of the task to retrieve.
     * @return Task if found, or 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new task.
     *
     * @param task Task to create.
     * @return Created task with 201 Created status.
     */
    @PostMapping
    public ResponseEntity<Task> createTask( @Valid @RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(201).body(createdTask);
    }

    /**
     * Updates an existing task by ID.
     *
     * @param id          ID of the task to update.
     * @param taskDetails Updated task details.
     * @return Updated task or 404 Not Found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        try {
            return ResponseEntity.ok(taskService.updateTask(id, taskDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a task by ID.
     *
     * @param id ID of the task to delete.
     * @return 204 No Content status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Marks a task as complete.
     *
     * @param id ID of the task to update.
     * @return Updated task or 404 Not Found.
     */
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> markTaskAsComplete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(taskService.markTaskAsComplete(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
