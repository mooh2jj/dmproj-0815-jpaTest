package com.example.dm0815.repository;

import com.example.dm0815.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Dao -> Repositroy
public interface TodoRepositroy extends JpaRepository<TodoEntity, Long> {
    // 단순 crud는 이정도만으로 충분!
}
