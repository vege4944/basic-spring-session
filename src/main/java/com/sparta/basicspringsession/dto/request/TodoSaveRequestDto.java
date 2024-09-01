package com.sparta.basicspringsession.dto.request;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {
    private String title;
    private String contents;
    private String username;
}
