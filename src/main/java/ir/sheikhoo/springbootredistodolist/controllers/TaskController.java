package ir.sheikhoo.springbootredistodolist.controllers;

import ir.sheikhoo.springbootredistodolist.domain.TaskDto;
import ir.sheikhoo.springbootredistodolist.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    private List<TaskDto> getAll(){
        return taskService.listAll();
    }

    @PostMapping("/task")
    private TaskDto saveOrUpdateTask(@RequestBody TaskDto taskDto){
        return taskService.saveOrUpdate(taskDto);
    }

    @GetMapping("/task/{id}")
    private TaskDto getById(@PathVariable("id") String id){
        return taskService.getById(id);
    }

    @PutMapping("/task/checked/{id}")
    private Boolean checkedAndUnchecked(@PathVariable("id") String id){
        return taskService.checkedAndUnchecked(id);
    }

    @DeleteMapping("/task/{id}")
    private void delete(@PathVariable("id") String id){
        taskService.delete(id);
    }
}
