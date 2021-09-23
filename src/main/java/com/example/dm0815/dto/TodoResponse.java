package com.example.dm0815.dto;

import com.example.dm0815.domain.Gender;
import com.example.dm0815.domain.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {

    private Long id;
    private String name;
    private String title;
    private Gender gender;

    public TodoResponse(TodoEntity todoEntity) {
        this.id = todoEntity.getId();
        this.name = todoEntity.getName();
        this.title = todoEntity.getTitle();
        this.gender = todoEntity.getGender();
    }
}
