package ir.sheikhoo.springbootredistodolist.services;

import ir.sheikhoo.springbootredistodolist.domain.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> listAll();
    TaskDto getById(String id);
    TaskDto saveOrUpdate(TaskDto taskDto);
    void delete(String id);
    Boolean checkedAndUnchecked(String id);
}
