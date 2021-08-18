package com.example.dm0815.service;

import com.example.dm0815.domain.TodoEntity;
import com.example.dm0815.dto.TodoRequest;
import com.example.dm0815.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    final private TodoRepository todoRepository;

    public TodoEntity add(TodoRequest todoRequest) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setName(todoRequest.getName());
        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setGender(todoRequest.getGender());
        return todoRepository.save(todoEntity);
    }

    public TodoEntity searchById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoEntity> searchAll() {
        return todoRepository.findAll();
    }

}
