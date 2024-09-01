package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.commentRequest.CommentSaveRequestDto;
import com.sparta.basicspringsession.dto.commentRequest.CommentUpdateRequestDto;
import com.sparta.basicspringsession.dto.commentResponse.CommentDetailResponseDto;
import com.sparta.basicspringsession.dto.commentResponse.CommentSaveResponseDto;
import com.sparta.basicspringsession.dto.commentResponse.CommentUpdateResponseDto;
import com.sparta.basicspringsession.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("todos/{todoId}/comments") //2단계: 댓글저장 //  여기서 주의할건 todos가 더 큰 범위에 엮여 있으니까 comment 앞에 넣어줘야해
    public ResponseEntity<CommentSaveResponseDto> saveComment(
            @PathVariable Long todoId,
            @RequestBody CommentSaveRequestDto commentSaveRequestDto
    ) {
        return ResponseEntity.ok(commentService.saveComment(todoId, commentSaveRequestDto));
    }

    @GetMapping("todos/{todoId}/comments") //2단계: 전체조회 //  일정의 댓글을 조회하는거니 이렇게 써줘야함
    public ResponseEntity<List<CommentDetailResponseDto>> getComments(@PathVariable Long todoId) {
        return ResponseEntity.ok(commentService.getComments(todoId));
    }

    @GetMapping("todos/{todoId}/comments/{commentId}") //2단계: 단건조회 // 프론트엔드를 위해 일관성있게 보여주기 위해 {todoId}를 넣어줌
    public ResponseEntity<CommentDetailResponseDto> getComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    @PutMapping("todos/{todoId}/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment (
            @PathVariable Long commentId,
            @RequestBody CommentUpdateRequestDto commentUpdateRequestDto
    ) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentUpdateRequestDto));
    }

    @DeleteMapping("todos/{todoId}/comments/{commentId}") //2단계: 삭제
    public void deleteComment (@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

}
