package com.example.dm0815.repository;

import com.example.dm0815.domain.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

// Dao -> Repositroy
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    @Query("SELECT b FROM TodoEntity b WHERE b.title LIKE %?1%")
    List<TodoEntity> findByTitle(String title);

    List<TodoEntity> findByName(String name);
}
