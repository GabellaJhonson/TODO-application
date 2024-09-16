package org.example.repository;

import org.example.domain.task.Task;

import java.util.Optional;
import java.util.List;

public interface TaskInterface {
    Optional<Task> findById(Long id);
    List<Task> findAllByUserId(Long userId);
    void assignToUserById(Long taskId, Long userId);
    void update (Task task);
    void delete (Long id);;
    void create (Task task);
}
