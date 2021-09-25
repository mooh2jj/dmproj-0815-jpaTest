package com.example.dm0815.service;

import com.example.dm0815.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select u from TodoEntity u").getResultList());

    }

    @Test
    void cacheRindTest() {
        System.out.println(todoRepository.findById(1L).get());
        System.out.println(todoRepository.findById(1L).get());
        System.out.println(todoRepository.findById(1L).get());
    }
}
