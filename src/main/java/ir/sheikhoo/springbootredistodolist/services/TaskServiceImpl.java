package ir.sheikhoo.springbootredistodolist.services;

import ir.sheikhoo.springbootredistodolist.Converters.TaskDtoToTask;
import ir.sheikhoo.springbootredistodolist.Converters.TaskToTaskDto;
import ir.sheikhoo.springbootredistodolist.domain.Task;
import ir.sheikhoo.springbootredistodolist.domain.TaskDto;
import ir.sheikhoo.springbootredistodolist.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;
    private final TaskToTaskDto taskToTaskDto;
    private final TaskDtoToTask taskDtoToTask;

    public TaskServiceImpl(TaskRepository taskRepository, TaskToTaskDto taskToTaskDto, TaskDtoToTask taskDtoToTask) {
        this.taskRepository = taskRepository;
        this.taskToTaskDto = taskToTaskDto;
        this.taskDtoToTask = taskDtoToTask;
    }

    @Override
    public List<TaskDto> listAll() {
        List<TaskDto> taskList=new ArrayList<>();
        taskRepository.findAll().forEach(task -> taskList.add(taskToTaskDto.convert(task)));
        return taskList;
    }

    @Override
    public TaskDto getById(String id) {
        return taskToTaskDto.convert(taskRepository.findById(id).orElse(new Task()));
    }

    @Override
    public TaskDto saveOrUpdate(TaskDto taskDto) {
        if(taskDto.getId()==null){
            taskDto.setCreateAt(LocalDateTime.now());
        }
        taskDto.setUpdateAt(LocalDateTime.now());

        Task task=taskDtoToTask.convert(taskDto);
        return taskToTaskDto.convert(taskRepository.save(task));
    }

    @Override
    public void delete(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Boolean checkedAndUnchecked(String id) {
        Task task=taskRepository.findById(id).orElse(null);
        if (task!=null){
            task.setChecked(!task.getChecked());
            task=taskRepository.save(task);
            return task.getChecked();
        }
        return false;
    }
}
