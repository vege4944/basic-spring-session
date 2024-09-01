package com.sparta.basicspringsession.dto.todoRequest;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {
    private String title;
    private String contents;
    private String username;
}
