package com.mainApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mainApplication.Model.Task;

/**
 * Repository interface for Task entity.
 * Provides CRUD operations for Task using Spring Data JPA.
 */
public interface TaskManagerRepo extends JpaRepository<Task, Long> {

}
