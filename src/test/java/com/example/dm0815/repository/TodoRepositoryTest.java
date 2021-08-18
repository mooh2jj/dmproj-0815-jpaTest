package com.example.dm0815.repository;

import com.example.dm0815.domain.Gender;
import com.example.dm0815.domain.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;

    //    @BeforeEach
    @Test
    public void createTest() {
        IntStream.rangeClosed(1,10).forEach( i ->{
            TodoEntity todoEntity = TodoEntity.builder()
                    .name("dsg" + i)
                    .title("title.." + i)
                    .gender(Gender.MALE)
                    .build();
            System.out.println(todoRepository.save(todoEntity));

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
        var allById = todoRepository.findAllById(Arrays.asList(1L, 2L, 3L));
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
        Optional<TodoEntity> result = todoRepository.findById(10L);

        if (result.isPresent()) {

            TodoEntity todoEntity = result.get();

            todoEntity.setName("xxx dsg");
            todoEntity.setTitle("xxx title");

            System.out.println(todoRepository.save(todoEntity));
        }

    }

    @Test
    public void deleteTest() {
//        todoRepositroy.deleteAll();
        todoRepository.deleteById(10L);
//        todoRepositroy.deleteAllById(Arrays.asList(1L,3L));
    }



}