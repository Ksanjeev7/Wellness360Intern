package com.mainApplication.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mainApplication.Model.Task;
import com.mainApplication.Repository.TaskManagerRepo;

/**
 * Service class that contains the business logic for managing tasks.
 * This class interacts with the Task repository to perform CRUD operations.
 */
@Service
public class TaskManagerService {

	@Autowired
    private TaskManagerRepo taskRepo;

    /**
     * Retrieves all tasks from the database.
     *
     * @return A list of all tasks.
     */
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param id The ID of the task to retrieve.
     * @return An Optional containing the task if found.
     * @throws RuntimeException if the task is not found.
     */
    public Optional<Task> getTaskById(Long id) {
        Optional<Task> byId = taskRepo.findById(id);
        if (byId.isPresent()) {
            return byId;
        } else {
            throw new RuntimeException("No Task found with Id: " + id);
        }
    }

    /**
     * Creates a new task and saves it to the database.
     *
     * @param task The task object to create.
     * @return The created task.
     */
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    /**
     * Updates an existing task by its ID.
     *
     * @param id The ID of the task to update.
     * @param taskDetails The new details of the task.
     * @return The updated task.
     * @throws RuntimeException if the task is not found.
     */
    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> taskOptional = taskRepo.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            // Update task fields
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setDateTime(taskDetails.getDateTime());
            task.setStatus(taskDetails.getStatus());
            return taskRepo.save(task);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id The ID of the task to delete.
     * @return A success message confirming the deletion.
     * @throws RuntimeException if the task is not found.
     */
    public String deleteTask(Long id) {
        Optional<Task> taskOptional = taskRepo.findById(id);
        if (taskOptional.isPresent()) {
            taskRepo.deleteById(id);
            return id + " Deleted Successfully.";
        } else {
            throw new RuntimeException("No Tasks Found with Id: " + id);
        }
    }

    /**
     * Marks a task as completed by setting its status to COMPLETED.
     *
     * @param id The ID of the task to update.
     * @return The updated task with status set to COMPLETED.
     * @throws RuntimeException if the task is not found.
     */
    public Task markTaskAsComplete(Long id) {
        // Retrieve the task by ID
        Optional<Task> taskOptional = taskRepo.findById(id);

        // If the task exists, update its status
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus(Task.Status.COMPLETED);
            return taskRepo.save(task);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }
}