package com.sparta.basicspringsession.dto.todoRequest;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {
    private String title;
    private String contents;
    private String username;
}
