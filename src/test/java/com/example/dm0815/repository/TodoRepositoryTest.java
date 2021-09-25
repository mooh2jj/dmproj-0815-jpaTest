package com.example.dm0815.repository;

import com.example.dm0815.domain.Gender;
import com.example.dm0815.domain.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;
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
//        var todoEntities = todoRepository.findAll();
        var todoEntity = todoRepository.findById(11L);
        var allById = todoRepository.findAllById(Arrays.asList(1L, 2L, 3L));
//        System.out.println("todoEntities: "+ todoEntities);

        List<TodoEntity> byName = todoRepository.findByName("dsg");
        System.out.println("todoEntitiy: "+ todoEntity.orElse(null));
        System.out.println("allById: "+ allById);
        System.out.println("byName: "+ byName);

    }

    @Test
    public void updateTest() {
//        TodoEntity todoEntity = TodoEntity.builder()
//                .id(10L)
//                .name("updated name")
//                .title("updated title...")
//                .build();
        Optional<TodoEntity> result = todoRepository.findById(10L);     // findById는 result -> Optional

        if (result.isPresent()) {

            TodoEntity todoEntity = result.get();

            todoEntity.setName("xxx dsg");
            todoEntity.setTitle("xxx title");

            System.out.println(todoRepository.save(todoEntity));
        }
//optional 안쓸 때
//        var todoEntity = todoRepository.findById(10L).orElseThrow(RuntimeException::new);
//
//        if(todoEntity != null){
//            todoEntity.setName("usususu");
//
//            todoRepository.save(todoEntity);
//        }

    }

    @Test
    public void deleteTest() {
//        todoRepositroy.deleteAll();
        todoRepository.deleteById(10L);
//        todoRepositroy.deleteAllById(Arrays.asList(1L,3L));
    }

    @Test
    public void pageTest() {
        List<TodoEntity> entities = todoRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        System.out.println("entities: "+ entities);

        Page<TodoEntity> todoEntities = todoRepository.findAll(PageRequest.of(1, 10, Sort.by("name").descending()));
        System.out.println("todoEntities: "+ todoEntities.getPageable());
        System.out.println("todoEntities: "+ todoEntities.getTotalElements());
        System.out.println("todoEntities: "+ todoEntities.getTotalPages());
        System.out.println("todoEntities: "+ todoEntities.getSort());

    }

    @Test
    void enumTest() {
        var todoEntity = todoRepository.findById(1L).orElseThrow(RuntimeException::new);
        todoEntity.setGender(Gender.FEMALE);

        todoRepository.save(todoEntity);

        todoRepository.findAll().forEach(System.out::println);
    }


    @Test
    public void queryTest() {
        todoRepository.findByTitle("1").forEach(System.out::println);
    }

}