package com.sparta.basicspringsession.repository;


import com.sparta.basicspringsession.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
