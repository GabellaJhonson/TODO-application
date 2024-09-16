package org.example.service;

import org.example.domain.user.User;

public interface UserService {

    User getById(Long id);

    User getByUsername(String username);

    User create(User user);

    User update(User user);

    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long id);
}
