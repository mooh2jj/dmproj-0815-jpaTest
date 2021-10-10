package com.example.dm0815.controller;

import com.example.dm0815.domain.Gender;
import com.example.dm0815.domain.TodoEntity;
import com.example.dm0815.dto.TodoRequest;
import com.example.dm0815.dto.TodoResponse;
import com.example.dm0815.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService service;

    /**
     * index test
     *
     */

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {

        log.info("create");

        if (ObjectUtils.isEmpty(request.getTitle())) {
            return ResponseEntity.badRequest().build();
        }
//        Optional.ofNullable(request.getTitle()).isEmpty()

        if (ObjectUtils.isEmpty(request.getName())) {
            request.setName("");
        }

        if (ObjectUtils.isEmpty(request.getGender())) {
            request.setGender(Gender.MALE);
        }

        TodoEntity result = this.service.add(request);
        System.out.println("result: " + result);

        return ResponseEntity.ok(new TodoResponse(result));
    }

//    private

}
