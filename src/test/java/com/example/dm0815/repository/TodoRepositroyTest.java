package com.example.dm0815.repository;

import com.example.dm0815.domain.Gender;
import com.example.dm0815.domain.TodoEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoRepositroyTest {

    @Autowired
    TodoRepositroy todoRepositroy;

    //    @BeforeEach
    @Test
    public void createTest() {
        IntStream.rangeClosed(1,10).forEach( i ->{
            TodoEntity todoEntity = TodoEntity.builder()
                    .name("dsg" + i)
                    .title("title.." + i)
                    .gender(Gender.MALE)
                    .build();
            System.out.println(todoRepositroy.save(todoEntity));

        });

    }

//    @AfterEach
//    public void afterEach() {
//        todoRepositroy.deleteAll();
//    }

    @Test
    public void readTest() {
//        var todoEntities = todoRepositroy.findAll();
//        var todoEntity = todoRepositroy.findById(11L);
        var allById = todoRepositroy.findAllById(Arrays.asList(1L, 2L, 3L));
//        System.out.println("todoEntities: "+ todoEntities);
//        System.out.println("todoEntitiy: "+ todoEntity.orElse(null));
        System.out.println("allById: "+ allById);

    }

    @Test
    public void updateTest() {
//        TodoEntity todoEntity = TodoEntity.builder()
//                .id(10L)
//                .name("updated name")
//                .title("updated title...")
//                .build();
        Optional<TodoEntity> result = todoRepositroy.findById(10L);

        if (result.isPresent()) {

            TodoEntity todoEntity = result.get();

            todoEntity.setName("xxx dsg");
            todoEntity.setTitle("xxx title");

            System.out.println(todoRepositroy.save(todoEntity));
        }

    }

    @Test
    public void deleteTest() {
//        todoRepositroy.deleteAll();
        todoRepositroy.deleteById(10L);
//        todoRepositroy.deleteAllById(Arrays.asList(1L,3L));
    }



}