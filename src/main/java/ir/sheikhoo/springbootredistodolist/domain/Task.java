package ir.sheikhoo.springbootredistodolist.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash("tasks")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private String id;
    @NotNull
    private String title;
    private String description;
    private Boolean checked=false;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
