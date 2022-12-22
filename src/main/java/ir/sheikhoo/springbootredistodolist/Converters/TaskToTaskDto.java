package ir.sheikhoo.springbootredistodolist.Converters;

import ir.sheikhoo.springbootredistodolist.domain.Task;
import ir.sheikhoo.springbootredistodolist.domain.TaskDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskToTaskDto implements Converter<Task, TaskDto> {

    @Override
    public TaskDto convert(@NotNull Task task) {
        TaskDto taskDto = new TaskDto();
        BeanUtils.copyProperties(task, taskDto);
        return taskDto;
    }

}
