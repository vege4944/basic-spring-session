package com.sparta.basicspringsession.repository;

import com.sparta.basicspringsession.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
