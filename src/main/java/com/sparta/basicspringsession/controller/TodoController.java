package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.todoRequest.TodoSaveRequestDto;
import com.sparta.basicspringsession.dto.todoRequest.TodoUpdateRequestDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoDetailResponseDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoSaveResponseDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoUpdateResponseDto;
import com.sparta.basicspringsession.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todos") // 1단계: 일정 저장
    public ResponseEntity<TodoSaveResponseDto> saveTodo (@RequestBody TodoSaveRequestDto todoSaveRequestDto) {
        return ResponseEntity.ok(todoService.saveTodo(todoSaveRequestDto));
    }

    @GetMapping("/todos/{todoId}") // 1단계: 단건 조회
    public ResponseEntity<TodoDetailResponseDto> getTodo (@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    @PutMapping("/todos/{todoId}") //1단계: 수정
    public ResponseEntity<TodoUpdateResponseDto> updateTodo (
            @PathVariable Long todoId,
            @RequestBody TodoUpdateRequestDto todoUpdateRequestDto) {
        return ResponseEntity.ok(todoService.updateTodo(todoId, todoUpdateRequestDto));
    }
}
