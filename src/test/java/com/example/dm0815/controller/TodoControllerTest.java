package com.example.dm0815.controller;

import com.example.dm0815.domain.Gender;
import com.example.dm0815.domain.TodoEntity;
import com.example.dm0815.dto.TodoRequest;
import com.example.dm0815.service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
@MockBean(JpaMetamodelMappingContext.class)
class TodoControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    TodoService todoService;

    private TodoEntity expected;

    @BeforeEach
    void setup() {
        this.expected = new TodoEntity();
        this.expected.setId(123L);
        this.expected.setTitle("test title");
        this.expected.setName("setup dsg");
        this.expected.setGender(Gender.MALE);
    }

    @Test
    @DisplayName("indexTest")
    void index() throws Exception {

        // given

        // when&then
        mvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andDo(print());

    }

    @Test
    void create() throws Exception{

        // given

        // when
        when(this.todoService.add(any(TodoRequest.class)))
                .then(i->{
                    TodoRequest todoRequest = i.getArgument(0, TodoRequest.class);
                    return new TodoEntity(this.expected.getId(),
//                            this.expected.getName(),
                            todoRequest.getName(),
                            todoRequest.getTitle(),
                            todoRequest.getGender()
                            );
                });

        TodoRequest todoRequest = new TodoRequest();
        todoRequest.setName("Any dsg");
        todoRequest.setTitle("Any title");
        todoRequest.setGender(Gender.FEMALE);

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(todoRequest);        // -> json change

        System.out.println("content: "+ content);

        // then
        this.mvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Any dsg"))
                .andExpect(jsonPath("$.title").value("Any title"))
                .andExpect(jsonPath("$.gender").value("FEMALE"))
                .andDo(print());

    }


}