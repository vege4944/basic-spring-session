package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.todoRequest.TodoSaveRequestDto;
import com.sparta.basicspringsession.dto.todoRequest.TodoUpdateRequestDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoDetailResponseDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoSaveResponseDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoSimpleResponseDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoUpdateResponseDto;
import com.sparta.basicspringsession.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todos") // 1단계: 일정 저장
    public TodoSaveResponseDto saveTodo (@RequestBody TodoSaveRequestDto todoSaveRequestDto) {
        return todoService.saveTodo(todoSaveRequestDto);
    }

    @GetMapping("/todos") //3단계
    public Page<TodoDetailResponseDto> getTodos ( //3단계: page 인터페이스 활용
          @RequestParam(defaultValue = "1") int page, //3단계 a. 페이지번호와 페이지 크기를 쿼리 파라미터로 전달하여 요청하는 항목 나타내기
          @RequestParam(defaultValue = "10") int size // 3단계 a. // 3단계 c. 디폴트 페이지 크기 10
    ){
        return todoService.getTodos(page, size);
    }

    @GetMapping("/todos/{todoId}") // 1단계: 단건 조회
    public TodoDetailResponseDto getTodo (@PathVariable Long todoId) {
        return todoService.getTodo(todoId);
    }

    @PutMapping("/todos/{todoId}") //1단계: 수정
    public TodoUpdateResponseDto updateTodo (
            @PathVariable Long todoId,
            @RequestBody TodoUpdateRequestDto todoUpdateRequestDto) {
        return todoService.updateTodo(todoId, todoUpdateRequestDto);
    }
}
