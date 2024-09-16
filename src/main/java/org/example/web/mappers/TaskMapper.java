package org.example.web.mappers;

import org.example.domain.task.Task;
import org.example.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);

    Task toEntity(TaskDto dto);

    List<TaskDto> toDto(List<Task> tasks);
}
