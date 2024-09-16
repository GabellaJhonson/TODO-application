package org.example.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.task.Task;
import org.example.domain.user.User;
import org.example.service.TaskService;
import org.example.service.UserService;
import org.example.web.dto.task.TaskDto;
import org.example.web.dto.user.UserDto;
import org.example.web.dto.validation.OnCreate;
import org.example.web.dto.validation.OnUpdate;
import org.example.web.mappers.TaskMapper;
import org.example.web.mappers.UserMapper;
import org.simpleframework.xml.core.Validate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }
    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
    @GetMapping("/{id}/tasks")
    public List<TaskDto> getAllByUserId(@PathVariable Long id){
        List <Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }
    @PostMapping("/{id}/tasks")
    public  TaskDto createTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task taskCreated = taskService.create(task, id);
        return taskMapper.toDto(taskCreated);
    }
}
