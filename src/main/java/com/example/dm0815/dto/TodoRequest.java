package com.example.dm0815.dto;

import com.example.dm0815.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    private String name;
    private String title;
    private Gender gender;
}
