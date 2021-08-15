package com.example.dm0815.repository;

import com.example.dm0815.domain.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoRepositroyTest {

    @Autowired
    TodoRepositroy todoRepositroy;

    @Test
    public void createTest() {
        IntStream.rangeClosed(1,10).forEach( i ->{
            TodoEntity todoEntity = TodoEntity.builder()
                    .name("dsg" + i)
                    .title("title.." + i)
                    .createdAt(LocalDateTime.now())
                    .build();
            System.out.println(todoRepositroy.save(todoEntity));

        });

    }

}