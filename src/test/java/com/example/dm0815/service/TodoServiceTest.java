package com.example.dm0815.service;

import com.example.dm0815.domain.Gender;
import com.example.dm0815.domain.TodoEntity;
import com.example.dm0815.dto.TodoRequest;
import com.example.dm0815.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock // mock class setting
    TodoRepository todoRepository;

    @InjectMocks
    TodoService todoService;

    @Test
    void add() {
        when(this.todoRepository.save(any(TodoEntity.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        TodoRequest todoRequest = new TodoRequest();
        todoRequest.setTitle("Test Title");

        TodoEntity todoEntity = this.todoService.add(todoRequest);
        System.out.println("todoEntity: "+ todoEntity);
        assertEquals(todoRequest.getTitle(), todoEntity.getTitle());
    }

    @Test
    void searchById() {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(123L);
        todoEntity.setName("test_dsg");
        todoEntity.setTitle("test_title");
        todoEntity.setGender(Gender.FEMALE);

        Optional<TodoEntity> optional = Optional.of(todoEntity);

        given(this.todoRepository.findById(anyLong()))
                .willReturn(optional);

        TodoEntity actual = this.todoService.searchById(123L);
        TodoEntity expected = optional.get();
        System.out.println("actual: "+ actual);
        System.out.println("expected: "+ expected);

        assertEquals(expected.getId(), actual.getId());

    }

}