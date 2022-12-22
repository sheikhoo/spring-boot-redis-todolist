package ir.sheikhoo.springbootredistodolist.repositories;

import ir.sheikhoo.springbootredistodolist.domain.Task;
import ir.sheikhoo.springbootredistodolist.domain.TaskDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,String> {

}
