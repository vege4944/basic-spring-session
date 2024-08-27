package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.BoardSaveRequestDto;
import com.sparta.basicspringsession.dto.BoardSaveResponseDto;
import com.sparta.basicspringsession.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardSaveResponseDto> saveBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto) {
        return ResponseEntity.ok(boardService.saveBoard(boardSaveRequestDto));
    }
}
