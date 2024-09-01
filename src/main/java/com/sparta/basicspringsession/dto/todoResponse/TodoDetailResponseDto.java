package com.sparta.basicspringsession.dto.todoResponse;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoDetailResponseDto { //1단계 단건조회, 3단계 특정조회: 할일제목, 할일내용, 댓글개수, 일정 작성일, 일정 수정일, 일정 작성 유저명
    private final Long id;
    private final String title; //3단계 b. 할일제목
    private final String contents; //3단계 b. 할일내용
    private final String username; //3단계 b. 유저명
    private final int commentCount; // 3단계 b. 댓글 개수
    private final LocalDateTime createdAt; //3단계 b. 일정 작성일
    private final LocalDateTime modifiedAt; //3단계 b. 일정 수정일


    public TodoDetailResponseDto(Long id, String title, String contents, String username, int commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
