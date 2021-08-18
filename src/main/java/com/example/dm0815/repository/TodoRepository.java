package com.example.dm0815.repository;

import com.example.dm0815.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

// Dao -> Repositroy
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    // 단순 crud는 이정도만으로 충분!
}
