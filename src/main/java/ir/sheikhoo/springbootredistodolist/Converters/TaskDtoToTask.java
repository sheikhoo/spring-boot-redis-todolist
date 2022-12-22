package ir.sheikhoo.springbootredistodolist.Converters;

import io.micrometer.common.util.StringUtils;
import ir.sheikhoo.springbootredistodolist.domain.Task;
import ir.sheikhoo.springbootredistodolist.domain.TaskDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoToTask implements Converter<TaskDto, Task> {
    @Override
    public Task convert(@NotNull TaskDto taskDto) {
        Task task=new Task();
        BeanUtils.copyProperties(taskDto,task);
        return task;
    }
}
