package com.mainApplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.mainApplication.Model.Task;
import com.mainApplication.Repository.TaskManagerRepo;
import com.mainApplication.Service.TaskManagerService;

public class TaskServiceTest {


    @Mock
    private TaskManagerRepo taskRepository;

    @InjectMocks
    private TaskManagerService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask() {
        // Arrange: Mock input and expected output
        Task inputTask = new Task();
        inputTask.setTitle("Test Task");
        inputTask.setDescription("Description of the test task");
        inputTask.setDateTime(LocalDate.of(2024, 11, 20));
        inputTask.setStatus(Task.Status.PENDING);

        Task savedTask = new Task();
        savedTask.setId(1L);
        savedTask.setTitle("Test Task");
        savedTask.setDescription("Description of the test task");
        savedTask.setDateTime(LocalDate.of(2024, 11, 20));
        savedTask.setStatus(Task.Status.PENDING);

        when(taskRepository.save(inputTask)).thenReturn(savedTask);

        // Act: Call the method under test
        Task result = taskService.createTask(inputTask);

        // Assert: Verify the result and interactions
        assertNotNull(result);
        assertEquals(savedTask.getId(), result.getId());
        assertEquals(savedTask.getTitle(), result.getTitle());
        assertEquals(savedTask.getDescription(), result.getDescription());
        assertEquals(savedTask.getDateTime(), result.getDateTime());
        assertEquals(savedTask.getStatus(), result.getStatus());

        verify(taskRepository, times(1)).save(inputTask);
    }
    
}
