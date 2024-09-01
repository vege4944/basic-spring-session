package com.sparta.basicspringsession.dto.todoResponse;

import lombok.Getter;

@Getter
public class TodoDetailResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final String username;

    public TodoDetailResponseDto(Long id, String title, String contents, String username) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
